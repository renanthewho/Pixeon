package com.renanalmeida.pixeon.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.renanalmeida.pixeon.domain.Exam;
import com.renanalmeida.pixeon.domain.HealthCareInstitution;

@Service
public class ExamServices {
	
	private static int idExame;
	static Map<Integer,Exam> mapExam = new HashMap<Integer,Exam>();
	static Map<Integer,Boolean> isRetrieve = new HashMap<Integer,Boolean>();
	static Map<String,HealthCareInstitution> institutionList = new HashMap<String,HealthCareInstitution>();
	
	public void inserirInstituicao(String cnpj, String name) {
		
		HealthCareInstitution instituicao = new HealthCareInstitution(cnpj,name);
		instituicao.atribuirPixeonCoins();
		institutionList.put(cnpj, instituicao);
	}
	
	public HealthCareInstitution buscarInstituicao (String cnpj) {
		return institutionList.get(cnpj);
	}
	
	public Object criarExame(String cnpjInstitution, String patientName, int patientAge, String patientGender, String physicianName,
                      int physicianCRM, String procedureName) {
		
		
		int idApoio = mapExam.size();
		HealthCareInstitution instituicao = buscarInstitution(cnpjInstitution);
		Exam exame = new Exam(instituicao, patientName, patientAge, patientGender, physicianName,
				physicianCRM, procedureName);
		int saldo = instituicao.consultarPixeonCoins(cnpjInstitution); //debitarPixeonCoins(instituicao);
		
		if(saldo > 0) {
			debitarPixeonCoins(instituicao);
		}else {
			String saldoInsuficiente = "Saldo insuficiente para realizar a operação.";
			return saldoInsuficiente;
		}

		idExame = idApoio + 1;
		mapExam.put(idExame, exame); 
		
		return idExame;
	}
	
	public String atualizarExame(int idExame, String cnpjInstitution, String patientName, int patientAge, String patientGender, String physicianName,
                                 int physicianCRM, String procedureName) {
		
		Exam exame = mapExam.get(idExame);
		
		Exam novoExame = new Exam(exame.getHealthcareInstitution(),patientName, patientAge, patientGender, physicianName, physicianCRM, procedureName);
		if (exame.getHealthcareInstitution().getCnpj().equals(cnpjInstitution)) {
			mapExam.replace(idExame, novoExame);
		}else {
			return "Exame pertence a outra instituição";
		}
		
		return "Exame alterado com sucesso";
	}
	
	public String apagarExame(int idExame, String cnpjInstitution) {

		Exam exame = mapExam.get(idExame);
		mapExam.get(idExame);
		if (exame.getHealthcareInstitution().getCnpj().equals(cnpjInstitution)) {
			mapExam.remove(idExame);
		}else {
			return "Exame pertence a outra instituição";
		}

		return "Exame excluido com sucesso";
}
	
	private void debitarPixeonCoins(HealthCareInstitution instituicao) {
		instituicao.debitarPixeonCoins();
	}


	private HealthCareInstitution buscarInstitution(String cnpj) {
		

		return institutionList.get(cnpj);
		
	}
	
	public Object getExame(int id, String cnpjInstituicao) {
		
		Boolean exameRetirado;
		
		Exam exame = new Exam();
		
		exame = mapExam.get(id);
		
		if (exame.getHealthcareInstitution().getCnpj().equals(cnpjInstituicao)) {
			
			try{
				exameRetirado = isRetrieve.get(id);
			}catch(NullPointerException e){
				exameRetirado = false;
			}
			
			if(exameRetirado != null && !exameRetirado) {
				
				exameRetirado = true;
				isRetrieve.put(id, exameRetirado);
			}else {
				debitarPixeonCoins(exame.getHealthcareInstitution());
			}
		}else {
			String mensagem = "Exame não faz parte da Instituição";
			return mensagem;
		}
		
		HealthCareInstitution ins = new HealthCareInstitution();
		int coins = ins.consultarPixeonCoins(cnpjInstituicao);
		if(coins <= 0) {
			String saldoInsuficiente = "Limite de Pixeon Coins excedido.";
			return saldoInsuficiente;
		}
		return exame;		
	}

}
