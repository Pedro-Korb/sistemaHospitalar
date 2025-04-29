package View;

import java.util.ArrayList;
import Classes.Consulta;
import Classes.Enfermeiro;
import Classes.FilaChegada;
import Classes.FilaPrioridade;
import Classes.Medico;
import Classes.Paciente;
import Classes.PilhaObservacao;
import Classes.SalaAtendimento;
import Classes.Triagem;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        /*=====================================================*/
        /*             FILAS ANTES DOS DADOS                   */
        /*=====================================================*/
        echo("=================================================");
        echo("FILAS VAZIAS");
        br();
        FilaChegada filaChegada = new FilaChegada();
        echo("Fila de Chegada");
        filaChegada.mostrarTodos();
        br();
        
        FilaPrioridade filaPrioridade = new FilaPrioridade();
        echo("Fila de Prioridade");
        filaPrioridade.mostrarTodos();
        br();
        
        PilhaObservacao pilhaObservacao = new PilhaObservacao();
        echo("Pilha Observação");
        pilhaObservacao.mostrarPacientes();
        echo("=================================================");
        ArrayList<Paciente> pacientes = new ArrayList<>();

        Paciente pac1 = new Paciente(1, "Ana Souza");
        pac1.setSintomas("febre", "dor de cabeça", "tosse");
        pacientes.add(pac1);

        Paciente pac2 = new Paciente(2, "Bruno Lima");
        pac2.setSintomas("falta de ar", "dor nas costas", "cansaço");
        pacientes.add(pac2);

        Paciente pac3 = new Paciente(3, "Cleber Silva");
        pac3.setSintomas("pressao alta", "dor peito", "tontura");
        pacientes.add(pac3);

        Paciente pac4 = new Paciente(4, "Daniela Rocha");
        pac4.setSintomas("dor abdominal", "náusea", "diarreia");
        pacientes.add(pac4);

        Paciente pac5 = new Paciente(5, "Eduardo Ramos");
        pac5.setSintomas("coceira", "vermelhidão", "inchaço");
        pacientes.add(pac5);

        Paciente pac6 = new Paciente(6, "Fernanda Alves");
        pac6.setSintomas("dor de garganta", "rouquidão", "dificuldade para engolir");
        pacientes.add(pac6);

        Paciente pac7 = new Paciente(7, "Gustavo Nunes");
        pac7.setSintomas("visão embaçada", "dores nos olhos", "dor de cabeça");
        pacientes.add(pac7);

        Paciente pac8 = new Paciente(8, "Helena Martins");
        pac8.setSintomas("fadiga", "palidez", "batimentos acelerados");
        pacientes.add(pac8);

        Paciente pac9 = new Paciente(9, "Igor Tavares");
        pac9.setSintomas("formigamento", "fraqueza muscular", "perda de equilíbrio");
        pacientes.add(pac9);

        Paciente pac10 = new Paciente(10, "Juliana Ferreira");
        pac10.setSintomas("sede excessiva", "urina frequente", "visão turva");
        pacientes.add(pac10);

        Enfermeiro enf1 = new Enfermeiro(1, "Maria Carvalho", true);
        Enfermeiro enf2 = new Enfermeiro(2, "Joana Pereira", true);
        Enfermeiro enf3 = new Enfermeiro(3, "Rosane Da Costa", true);

        Medico med1 = new Medico(1, "Dr. Carlos", "Clínico Geral", true);
        Medico med2 = new Medico(3, "Dr. Mateus", "Cardiologista", true);
        Medico med3 = new Medico(4, "Dr. Diego", "Oftalmologista", true);

        SalaAtendimento sala1 = new SalaAtendimento(1, 100, "Geral", true);
        SalaAtendimento sala2 = new SalaAtendimento(2, 101, "RAIO-X", true);
        SalaAtendimento sala3 = new SalaAtendimento(3, 102, "Geral", true);
        Triagem triagem = new Triagem(filaChegada, filaPrioridade);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int tempo = 0;

        while (true) {
            System.out.println("PRESSIONE ENTER PARA AVANÇAR 15 MINUTOS...");
            scanner.nextLine();
            limparConsole();
            tempo += 15;

            simular15Minutos(pacientes, filaChegada, filaPrioridade, pilhaObservacao,
                    triagem, new Enfermeiro[]{enf1, enf2, enf3},
                    new Medico[]{med1, med2, med3},
                    new SalaAtendimento[]{sala1, sala2, sala3},
                    random);
            
            echo("=== TEMPO TOTAL: " + tempo + " MINUTOS ===");
            mostrarEstado(filaChegada, filaPrioridade, pilhaObservacao);
        }
    }

    public static void simular15Minutos(ArrayList<Paciente> todosPacientes,
                                        FilaChegada filaChegada,
                                        FilaPrioridade filaPrioridade,
                                        PilhaObservacao pilhaObservacao,
                                        Triagem triagem,
                                        Enfermeiro[] enfermeiros,
                                        Medico[] medicos,
                                        SalaAtendimento[] salas,
                                        Random random) {
    	
    	int randomProcesso = random.nextInt(3) + 1;
    	
    	// Randomiza um valor com base no total de pessoas na lista inicial, seta como paciente novo e retira da lista inicial
    	if(randomProcesso == 1 && todosPacientes.size() > 0) {
    		int valorRandomTodosPacientes = random.nextInt(todosPacientes.size());
    		Paciente novo = todosPacientes.get(valorRandomTodosPacientes);
    		todosPacientes.remove(valorRandomTodosPacientes);    		
    		filaChegada.setListaPaciente(novo);
    		echo("O paciente '" + novo.getNomePaciente() + "' entrou na fila de chegada");
    	}
    	
    	int valorRandomEnfermeiros = random.nextInt(enfermeiros.length);
    	Enfermeiro enfermeiroTriagem = enfermeiros[valorRandomEnfermeiros];
    	
    	if(randomProcesso == 2) {
	        if (enfermeiroTriagem.isDisponivel() && !filaChegada.getListaPaciente().estaVazia()) {
	            Paciente pacienteTriagem = filaChegada.getListaPaciente().getPrimeiro();
	            int prioridadeAleatoria = random.nextInt(5) + 1;
	            triagem.realizaTriagem(pacienteTriagem, enfermeiroTriagem, prioridadeAleatoria);
	            echo("Triagem feita pela enfermeira '" + enfermeiroTriagem.getNomeEnfermeiro() + "' para '" + pacienteTriagem.getNomePaciente() + "' com prioridade " + prioridadeAleatoria);
	        }
    	}
    	
        int valorRandomMedicos = random.nextInt(medicos.length);
        Medico medicoConsulta = medicos[valorRandomMedicos];
        
        
        int valorRandomSalaAtendimento = random.nextInt(salas.length);
        SalaAtendimento salaAtendimento = salas[valorRandomSalaAtendimento];
        
        
        if(randomProcesso == 3) {
        	if (!filaPrioridade.estaVazia()) {
        	    Paciente pacienteConsulta = filaPrioridade.getPrimeiro();
        	    if (pacienteConsulta != null) {
	
		        	boolean randomBoolean = random.nextBoolean();
		            new Consulta(pilhaObservacao, filaPrioridade, salaAtendimento, medicoConsulta, randomBoolean);
		            wbold("Paciente consulta: " + pacienteConsulta.getNomePaciente());
		            wbold ("Consulta realizada com " + medicoConsulta.getNomeMedico() + " na sala " + salaAtendimento.getNumeracaoSala());
		            if (randomBoolean) {
		            	echo("Paciente movido para Pilha de observação para aguardo de leito");
		            }
		            else {
		            	echo("Paciente liberado");
		            }
		        }
	        }
        }

    }

    public static void mostrarEstado(FilaChegada filaChegada,
                                     FilaPrioridade filaPrioridade,
                                     PilhaObservacao pilhaObservacao) {
        echo("\n--- Estado Atual das Filas ---");
        echo("Fila de Chegada:");
        filaChegada.mostrarTodos();
        br();
        echo("Fila de Prioridade:");
        filaPrioridade.mostrarTodos();
        br();
        echo("Pilha de Observação:");
        pilhaObservacao.mostrarPacientes();
        echo("-----------------------------------");
    }

    public static void echo(String texto) {
        System.out.println(texto);
    }

    public static void br() {
        System.out.println();
    }
    
    public static void limparConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    
    public static void wred(String texto) {    
        System.out.println("\u001B[31m"+ texto + "\u001B[0m");
    }
    
    public static void wbold(String texto) {
    	System.out.println("\u001B[21m" + texto + "\u001B[0m");
    }
}
