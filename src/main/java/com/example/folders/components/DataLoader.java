package com.example.folders.components;

import com.example.folders.models.File;
import com.example.folders.models.Folder;
import com.example.folders.models.User;
import com.example.folders.repositories.FileRepository;
import com.example.folders.repositories.FolderRepository;
import com.example.folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;



    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Gavin");
        userRepository.save(user1);

        User user2 = new User("Sheila");
        userRepository.save(user2);




        Folder images = new Folder("Images",  user1);
        folderRepository.save(images);

        Folder documents = new Folder("Documents", user2);
        folderRepository.save(documents);


        File image1 = new File("Holiday Snap 1", "jpg", 10, images );
        fileRepository.save(image1);

        File image2 = new File("Holiday Snap 2", "jpg", 10, images );
        fileRepository.save(image2);

        File image3 = new File("Holiday Snap 3", "jpg", 10, images );
        fileRepository.save(image3);

        File image4 = new File("Holiday Snap 4", "jpg", 10, images );
        fileRepository.save(image4);

        File text1 =  new File("CV", "txt", 2, documents);
        fileRepository.save(text1);

        File text2 = new File("Memoirs", "txt", 2, documents);
        fileRepository.save(text2);

        File text3  = new File("Accounts", "txt", 2, documents);
        fileRepository.save(text3);

        File text4 = new File("Story", "txt", 2, documents);
        fileRepository.save(text4);

        documents.addFile(text1);
        documents.addFile(text2);
        documents.addFile(text3);
        documents.addFile(text4);
        folderRepository.save(documents);

        images.addFile(image1);
        images.addFile(image2);
        images.addFile(image3);
        images.addFile(image4);
        folderRepository.save(images);


        user1.addFolder(images);
        userRepository.save(user1);

        user2.addFolder(documents);
        userRepository.save(user2);




    }
}
