package GUI;

import arquivos.CreateFile;
import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.Point;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.MouseWheelEvent;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public final class Tela extends JFrame {

    private final JButton btnCompilador;
    private final JPanel panelCodigo;
    private final JPanel panelConsole;
    private final JPanel panelArvore;
    private final JScrollPane scrollPane;
    private JScrollPane scrollPane_2;
    private final JScrollPane scrollPane_1;
    private JTextPane textArquivo;
    private final JTextArea textMsg;
    private final JTextArea textConsole;
    private File file;
    private String campoTexto = null;

    private boolean controleArquivo = false;

    /**
     * Create the application.
     */
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    public Tela() {

        this.lookFeel();

        setBackground(Color.LIGHT_GRAY);
        setTitle("iCimpili");
        setBounds(100, 100, 870, 618);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.gray);

        JLabel lblMensagem = new JLabel("Irviri Sintititica");
        lblMensagem.setBounds(590, 55, 97, 14);
        lblMensagem.setForeground(Color.white);
        getContentPane().add(lblMensagem);

        panelArvore = new JPanel();
        panelArvore.setBounds(580, 75, 250, 485);
        getContentPane().add(panelArvore);
        panelArvore.setLayout(null);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 353, 488);
        panelArvore.add(scrollPane_1);

        textMsg = new JTextArea();

        textMsg.setForeground(Color.ORANGE);
        textMsg.setFont(new Font("Arial", Font.PLAIN, 25));
        textMsg.setEditable(false);
        scrollPane_1.setViewportView(textMsg);

        panelCodigo = new JPanel();
        panelCodigo.setBounds(10, 75, 557, 313);

        getContentPane().add(panelCodigo);
        panelCodigo.setLayout(null);

        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches(("(\\W)*(iscrivi|principil|fincii|si|sinii|inquinti|fici|intiiri|dicimil|ritirni)"))) {
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        }
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            @Override
            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches(("(\\W)*(iscrivi|principil|fincii|si|sinii|inquinti|fici|intiiri|dicimil|ritirni)"))) {
                    setCharacterAttributes(before, after - before, attr, false);
                } else {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }
            }
        };

        textArquivo = new JTextPane(doc);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(0, 0, 557, 313);
        textArquivo.setBounds(0, 0, 557, 313);
        scrollPane_2.setViewportView(textArquivo);

        TextLineNumber tln = new TextLineNumber(textArquivo);
        scrollPane_2.setRowHeaderView(tln);
        panelCodigo.add(scrollPane_2);
        /*
        textMsg.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 15));
        textMsg.setEditable(false);
        scrollPane_1.setViewportView(textMsg);
         */
        panelConsole = new JPanel();
        panelConsole.setBounds(10, 424, 557, 135);
        getContentPane().add(panelConsole);
        panelConsole.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 964, 135);
        panelConsole.add(scrollPane);

        textConsole = new JTextArea();
        textConsole.setForeground(Color.RED);
        textConsole.setFont(new Font("Consolas", Font.PLAIN | Font.ITALIC, 16));
        scrollPane.setViewportView(textConsole);
        textConsole.setEditable(false);

        JLabel lblArquivo = new JLabel("Irqiivi");
        lblArquivo.setForeground(Color.white);
        lblArquivo.setBounds(20, 55, 46, 14);
        getContentPane().add(lblArquivo);

        JLabel lblConsole = new JLabel("Cinsili");
        lblConsole.setForeground(Color.white);
        lblConsole.setBounds(20, 399, 80, 14);
        getContentPane().add(lblConsole);

        btnCompilador = new JButton("Cimpili");
        btnCompilador.setBounds(250, 20, 100, 36);
        getContentPane().add(btnCompilador);
        btnCompilador.setBackground(Color.GREEN);

        scrollPane_2.addMouseWheelListener((MouseWheelEvent arg0) -> {
            Point point = scrollPane_2.getViewport().getViewPosition();

        });

    }

    public void lookFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null,
                    "Nao foi possivel executar");
        }
    }

    public JButton getCompilar() {
        return btnCompilador;
    }

    public JTextPane getTextArquivo() {
        return textArquivo;
    }

    public void setConsole(String msg) {
        textConsole.append(msg);
        String res1[] = msg.split("line ");
        if (res1.length > 1) {
            String res2[] = res1[1].split(",");
            if (res2.length > 0) {
                int res3 = Integer.parseInt(res2[0]);
                String teste[] = textArquivo.getText().split("\n");
                int i = 0, f;
                for (int x = 0; x < res3 - 1; x++) {
                    i += teste[x].length();
                }
                f = i + teste[res3 - 1].length();
                Highlighter h = textArquivo.getHighlighter();
                try {
                    h.addHighlight(0, i - 1, new DefaultHighlighter.DefaultHighlightPainter(Color.white));
                    h.addHighlight(i, f, new DefaultHighlighter.DefaultHighlightPainter(Color.red));
                    h.addHighlight(f + 1, textArquivo.getText().length(), new DefaultHighlighter.DefaultHighlightPainter(Color.white));
                } catch (BadLocationException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print("mostrou erro" + res3);
            }
        }
    }

    public void setMsg(String msg) {

        System.out.println(msg);
        textMsg.append(msg);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(String campoTexto) {
        this.campoTexto = campoTexto;
    }

    public boolean getControleArquivo() {
        return controleArquivo;
    }

    public void setControleArquivo(boolean controle) {
        this.controleArquivo = controle;
    }

    public void setVazioConsoleMsg() {
        textConsole.setText("");
        textMsg.setText("");
    }

    public void salvarComo() {
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = jc.showSaveDialog(null);

        if (i != 1) {

            file = jc.getSelectedFile();
            campoTexto = new String();
            controleArquivo = true;
            CreateFile create = new CreateFile();

            create.openFile(file);
            create.addRecords(textArquivo.getText());
            create.closeFile();

            campoTexto = textArquivo.getText();
        }
    }

    public void salvar() {
        campoTexto = new String();
        controleArquivo = true;

        if (file != null) {
            campoTexto = new String();
            controleArquivo = true;
            CreateFile create = new CreateFile();

            create.openFile(file);
            create.addRecords(textArquivo.getText());
            create.closeFile();

            campoTexto = textArquivo.getText();
        } else {
            salvarComo();
        }
    }

    public static void escritor(String texto) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(
        "C:

        buffWrite.append(texto);
        buffWrite.close();
    }

}
