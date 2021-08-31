package com.superay.stream;

import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;

        int numberOfPrintableCharacter=94;

        int numberOfCharactersPerLine=72;

        int start = firstPrintableCharacter;

        while (true){
            for (int i = start; i < start + numberOfCharactersPerLine; i++){
                out.write(
                        ((i - firstPrintableCharacter) % numberOfPrintableCharacter) + firstPrintableCharacter
                );
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1)-firstPrintableCharacter) % numberOfPrintableCharacter + firstPrintableCharacter;
        }
    }
}
