package textgeneration;

import static org.asciidoctor.Asciidoctor.Factory.create;
import static org.asciidoctor.OptionsBuilder.options;

import org.asciidoctor.Asciidoctor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contverts a file written with ascii doc to a html5 or pdf file.
 *
 * @author Alfred Loran
 * @version 1.0
 */
public class Textgeneration {

    private Asciidoctor asciidoctor;

    /**
     * Constructor.
     *
     * @since 1.0
     */
    public Textgeneration() {
        asciidoctor = create();
    }

    /**
     * Creates the documents.
     *
     * @param fileNameToConvert The file name which should be converted.
     * @since 1.0
     */
    public void createDocuments(String fileNameToConvert) {
        generateDocument(fileNameToConvert);
    }

    /**
     * Generates the html 5 file.
     *
     * @param fileNameToConvert The name of the file to convert.
     * @since 1.0
     */
    private void generateDocument(String fileNameToConvert) {
        asciidoctor.convertFile(new File("src/main/resources/documents/" + fileNameToConvert), new HashMap<String, Object>());
        convertDocumentIntoPDF(fileNameToConvert);
    }

    /**
     * Converts the file into pdf.
     *
     * @param fileNameToConvert The name of the file to convert.
     * @since 1.0
     */
    private void convertDocumentIntoPDF(String fileNameToConvert) {
        Map<String, Object> options = options()
                .inPlace(true)
                .backend("pdf")
                .asMap();
        asciidoctor.convertFile(new File("src/main/resources/documents/" + fileNameToConvert), options);
    }

    /**
     * Main method.
     *
     * @param args The arguments may set.
     * @since 1.0
     */
    public static void main(String[] args) {
        Textgeneration textgeneration = new Textgeneration();
        textgeneration.createDocuments("");
    }
}
