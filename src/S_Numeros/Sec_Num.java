package S_Numeros;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Sec_Num {

    public boolean leer(List<String> secuencia) throws IOException {
        try {
            imprimirtxt(secuencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public File verificarRuta() throws IOException {
        File file = new File("ordenado/Problema3a_odernado.txt");
        File secuencia_n = new File(file.getParent());
        if (secuencia_n.isFile()){
            if (!file.exists()){
                file.createNewFile();
            }
        }else{
            secuencia_n.mkdir();
            file.createNewFile();
        }
        return file;
    }

    public void imprimirtxt(List<String> secuncia_C) throws IOException{
        try {
            File file = verificarRuta();
            FileWriter fw = new FileWriter(file);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for (int x=0;x<secuncia_C.size();x++){
                    bw.write(secuncia_C.get(x));
                    bw.write("; ");
                }
                JOptionPane.showMessageDialog(null,"El Registro ha sido ordenado y grabado en el archivo Problema3a_odernado.txt exitosamente");
            }
            fw.close();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
