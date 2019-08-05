package recovery;

import parser.*;

public class First {

    static public final RecoverySet start = new RecoverySet();
    static public final RecoverySet variosFunc = new RecoverySet();
    static public final RecoverySet main = new RecoverySet();
    static public final RecoverySet varDecl = new RecoverySet();
    static public final RecoverySet atribuicao = new RecoverySet();
    static public final RecoverySet atribuir = new RecoverySet();
    static public final RecoverySet talvezListaExp = new RecoverySet();
    static public final RecoverySet loop = new RecoverySet();
    static public final RecoverySet listaExp = new RecoverySet();
    static public final RecoverySet listaExp2 = new RecoverySet();
    static public final RecoverySet mdeclaracao = new RecoverySet();
    static public final RecoverySet exp = new RecoverySet();
    static public final RecoverySet fator = new RecoverySet();
    static public final RecoverySet talvezFator = new RecoverySet();
    static public final RecoverySet seqComandos = new RecoverySet();
    static public final RecoverySet comando = new RecoverySet();
    static public final RecoverySet talvezElse = new RecoverySet();
    static public final RecoverySet exp_logicas = new RecoverySet();
    static public final RecoverySet fator_logico = new RecoverySet();
    static public final RecoverySet func = new RecoverySet();
    static public final RecoverySet talvezListaArg = new RecoverySet();
    static public final RecoverySet listaArg = new RecoverySet();
    static public final RecoverySet listaArg2 = new RecoverySet();
    static public final RecoverySet tipo = new RecoverySet();

    static {

        start.add(new Integer(iCimpilirConstants.EOF));

        main.add(new Integer(iCimpilirConstants.FUNCAO));
        main.add(new Integer(iCimpilirConstants.EOF));

        variosFunc.add(new Integer(iCimpilirConstants.EOF));

        varDecl.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        varDecl.add(new Integer(iCimpilirConstants.IF));
        varDecl.add(new Integer(iCimpilirConstants.WHILE));
        varDecl.add(new Integer(iCimpilirConstants.DO));
        varDecl.add(new Integer(iCimpilirConstants.RETURN));
        varDecl.add(new Integer(iCimpilirConstants.PRINTF));

        tipo.add(new Integer(iCimpilirConstants.IDENTIFICADOR));

        atribuicao.add(new Integer(iCimpilirConstants.IF));
        atribuicao.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        atribuicao.add(new Integer(iCimpilirConstants.WHILE));
        atribuicao.add(new Integer(iCimpilirConstants.DO));
        atribuicao.add(new Integer(iCimpilirConstants.RETURN));
        atribuicao.add(new Integer(iCimpilirConstants.PRINTF));
        atribuicao.add(new Integer(iCimpilirConstants.FECHACHAVES));

        atribuir.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        atribuir.add(new Integer(iCimpilirConstants.IF));
        atribuir.add(new Integer(iCimpilirConstants.WHILE));
        atribuir.add(new Integer(iCimpilirConstants.DO));
        atribuir.add(new Integer(iCimpilirConstants.RETURN));
        atribuir.add(new Integer(iCimpilirConstants.PRINTF));

        atribuir.add(new Integer(iCimpilirConstants.FECHACHAVES));

        talvezListaExp.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        loop.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        loop.add(new Integer(iCimpilirConstants.IF));
        loop.add(new Integer(iCimpilirConstants.WHILE));
        loop.add(new Integer(iCimpilirConstants.DO));
        loop.add(new Integer(iCimpilirConstants.RETURN));
        loop.add(new Integer(iCimpilirConstants.PRINTF));

        loop.add(new Integer(iCimpilirConstants.FECHACHAVES));

        listaExp.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        listaExp2.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        mdeclaracao.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        mdeclaracao.add(new Integer(iCimpilirConstants.IF));
        mdeclaracao.add(new Integer(iCimpilirConstants.WHILE));
        mdeclaracao.add(new Integer(iCimpilirConstants.DO));
        mdeclaracao.add(new Integer(iCimpilirConstants.RETURN));
        mdeclaracao.add(new Integer(iCimpilirConstants.PRINTF));

        mdeclaracao.add(new Integer(iCimpilirConstants.FECHACHAVES));

        exp.add(new Integer(iCimpilirConstants.PONTOEVIRGULA));
        exp.add(new Integer(iCimpilirConstants.FECHAPARENTESES));
        exp.add(new Integer(iCimpilirConstants.OP));
        exp.add(new Integer(iCimpilirConstants.VIRGULA));

        fator.add(new Integer(iCimpilirConstants.PONTOEVIRGULA));
        fator.add(new Integer(iCimpilirConstants.FECHAPARENTESES));
        fator.add(new Integer(iCimpilirConstants.OP));
        fator.add(new Integer(iCimpilirConstants.VIRGULA));

        talvezFator.add(new Integer(iCimpilirConstants.PONTOEVIRGULA));
        talvezFator.add(new Integer(iCimpilirConstants.FECHAPARENTESES));
        talvezFator.add(new Integer(iCimpilirConstants.OP));
        talvezFator.add(new Integer(iCimpilirConstants.VIRGULA));

        seqComandos.add(new Integer(iCimpilirConstants.FECHACHAVES));

        comando.add(new Integer(iCimpilirConstants.IDENTIFICADOR));
        comando.add(new Integer(iCimpilirConstants.IF));
        comando.add(new Integer(iCimpilirConstants.WHILE));
        comando.add(new Integer(iCimpilirConstants.DO));
        comando.add(new Integer(iCimpilirConstants.RETURN));
        comando.add(new Integer(iCimpilirConstants.PRINTF));
        comando.add(new Integer(iCimpilirConstants.FECHACHAVES));

        talvezElse.add(new Integer(iCimpilirConstants.PONTOEVIRGULA));

        exp_logicas.add(new Integer(iCimpilirConstants.OPL));
        exp_logicas.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        fator_logico.add(new Integer(iCimpilirConstants.OPL));
        fator_logico.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        func.add(new Integer(iCimpilirConstants.FUNCAO));
        func.add(new Integer(iCimpilirConstants.EOF));

        talvezListaArg.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        listaArg.add(new Integer(iCimpilirConstants.FECHAPARENTESES));

        listaArg2.add(new Integer(iCimpilirConstants.FECHAPARENTESES));
    }
}
