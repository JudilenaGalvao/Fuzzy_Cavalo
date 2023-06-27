package com.myFuzzyProject;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class TippingClass {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		float peso, altura;
		
		String filename = "tipper.fcl"; //arquivo FCL
		FIS fis = FIS.load(filename, true); //carregamento

		if (fis == null) { //erro durante o carregamento do arquivo
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

	
		
		// Defini��es de vari�veis de entrada FIS
		System.out.println("Qual a altura do cavalo em uma escala de (110-baixo 190-alto)?");
		altura = ler.nextFloat();
		System.out.println("Qual o peso do cavalo em uma escala de (200-magro 900-obeso)?");
		peso = ler.nextFloat();
		fb.setVariable("altura", altura);  //8,5
		fb.setVariable("peso", peso);  //7,5  tip=19.99999

		// Execu��o do sistema
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("racao").defuzzify();
		fb.getVariable("volumoso").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println("Racao: " + fb.getVariable("racao").getValue());
		System.out.println("Volumoso: " + fb.getVariable("volumoso").getValue());
	}

}
