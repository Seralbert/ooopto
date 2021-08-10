package ys.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ys.project.model.GFDvoc;
import ys.project.repository.GFDVocRepo;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 25.12.2019.
 *  Реализация сервиса классификатора типов документов
 */
@Service
public class GFDVocServiceImpl {
    @Value("${upload.path}")
    private String upLoadPath;

    @Autowired
    private GFDVocRepo repo;

    @PostConstruct
    public void init(){
        if(getAllCode().isEmpty()){
            //System.out.println("Грузим приложение 2");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(upLoadPath + "/" + "codes.txt"), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] s = line.split("\t");
                    GFDvoc o = new GFDvoc(s[0],s[1]);
                    repo.save(o);
                }
                System.out.println("Приложение 2 загружено");
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла");
            }
        }
    }
    public List<String> getAllCode(){
        List<String> req = new ArrayList<>();

        for (GFDvoc record: repo.findAll()
             ) {
            req.add(record.getCod());
        }
        return req;
    }
    public List<String> getAllDescriptions(){
        List<String> req = new ArrayList<>();

        for (GFDvoc record: repo.findAll()
             ) {
            req.add(record.getDescription());
        }
        return req;
    }
}
