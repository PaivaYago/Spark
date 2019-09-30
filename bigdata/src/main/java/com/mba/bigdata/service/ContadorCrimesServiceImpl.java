package com.mba.bigdata.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.bigdata.config.SparkConfig;
import com.mba.bigdata.entity.ArquivoCrime;

@Service
public class ContadorCrimesServiceImpl implements ContadorCrimesService {

	@Autowired
	private SparkConfig sparkConfig;
//	JavaSparkContext sc;
	

//	public Map<String, Long> getCount(List<String> wordList) {
//		JavaRDD<String> words = sc.parallelize(wordList);
//		Map<String, Long> wordCounts = words.countByValue();
//		return wordCounts;
//	}

	public Collection<ArquivoCrime> getByMunicipio(String municipio) {
		
		try {
			
			
			Dataset<Row> dataset = sparkConfig.sparkSession().read().csv
					(ArquivoCrime.class.getResource("BaseMunicipioMensal.csv").toString().replaceAll("%20", " "));
			
			JavaRDD<ArquivoCrime> crime =  dataset 
					.javaRDD().map(line -> {
						ArquivoCrime arq = new ArquivoCrime(line.getInt(0), line.getString(1), line.getInt(2), line.getInt(3), line.getString(4),
								line.getString(5), line.getInt(6), line.getInt(7), line.getInt(8));					
						return arq;
					});
			
			Dataset<Row> indCrime = sparkConfig.sparkSession().createDataFrame(crime, ArquivoCrime.class);
			indCrime.createOrReplaceTempView("crimes");
			
			Dataset<Row> dataSetRows = sparkConfig.sparkSession().sql("SELECT fmun AS municipio, mes AS mes, "
					+ "vano AS ano, regiao AS regiao, hom_doloso AS homicidio_doloso,"
					+ "tentat_hom AS tentativa_homicidio, hom_culposo AS homicidio_culposo "
					+ "FROM crimes WHERE fmun = '" + municipio + "ORDER BY mes, vano");
			List<Row> rows = dataSetRows.collectAsList();
			
			Collection<ArquivoCrime> crimes = new ArrayList<ArquivoCrime>();
			
			for(Row row : rows) {
				
				ArquivoCrime arqCrim = new ArquivoCrime();
				arqCrim.setFmun(row.getAs("municipio"));
				arqCrim.setMes(row.getAs("mes"));
				arqCrim.setVano(row.getAs("ano"));
				arqCrim.setRegiao(row.getAs("regiao"));
				arqCrim.setHom_doloso(row.getAs("homicidio_doloso"));
				arqCrim.setTentat_hom(row.getAs("tentativa_homicidio"));
				arqCrim.setHom_culposo(row.getAs("homicidio_culposo"));
				
				crimes.add(arqCrim);
			}
			
			return crimes;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
