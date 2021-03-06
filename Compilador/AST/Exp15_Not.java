package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;

public class Exp15_Not implements Exp {
	public final Exp exp;

	public Exp15_Not(Exp exp) {
		this.exp = exp;
	}

	public int computeType() throws CompilerExc {
		if (exp.computeType() == SymbolTable.BOOL) {
			return SymbolTable.BOOL;
		}
		
		throw new IncorrectTypesExc("Incorrect type in not operation.");
	}

	public String generateCode() {
        return "(" + exp.generateCode() + ").not()";
    }
}