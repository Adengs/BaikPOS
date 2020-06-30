package com.codelabs.konspirasisnack.helper;

import java.util.ArrayList;
import java.util.List;

public class DummyUtils {

    public static List<String> getDummy(){
        List<String> s = new ArrayList<>();
        for (int i= 1 ; i<= 10;i++)
            s.add("Data "+i);

        return s;
    }

    public static List<String> getJenisKelamin(){
        List<String> s = new ArrayList<>();
        s.add("Pilih jenis kelamin");
        s.add("Laki-laki");
        s.add("Perempuan");
        return s;
    }
}
