package com.ttn.linksharing.service;

import com.ttn.linksharing.dao.ResourceDaoImpl;
import com.ttn.linksharing.model.DocumentResource;
import com.ttn.linksharing.model.LinkResource;
import com.ttn.linksharing.model.Topic;
import com.ttn.linksharing.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Component
public class ResourceServiceImpl {

    @Autowired
    ResourceDaoImpl resourceDao;

    public boolean addLinkResource(User user, Topic topic, String url, String description)
    {
        boolean check;
        try {
            LinkResource linkResource = new LinkResource();
            linkResource.setUrl(url);
            linkResource.setDescription(description);
            linkResource.setCreatedBy(user);
            linkResource.setTopic(topic);
            linkResource.setDateCreated(new Date());
            linkResource.setLastUpdate(new Date());

            check = resourceDao.addLinkResourceDao(linkResource);
            if (check == true)
            {
                System.out.println("link resource added");
                return true;
            }
            else
            {
                System.out.println("link resource not added");
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("prob in addlinkresource " + e);
        }

        return false;
    }

    public boolean addDocResource(User user, Topic topic, String filepath, String description)
    {
        boolean check;
        try {
            DocumentResource documentResource = new DocumentResource();
            documentResource.setFilePath(filepath);
            documentResource.setDescription(description);
            documentResource.setCreatedBy(user);
            documentResource.setTopic(topic);
            documentResource.setDateCreated(new Date());
            documentResource.setLastUpdate(new Date());

            check = resourceDao.addDocResourceDao(documentResource);
            if (check == true)
            {
                System.out.println("doc resource added");
                return true;
            }
            else
            {
                System.out.println("doc resource not added");
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("prob in addlinkresource " + e);
        }

        return false;
    }

    public String singleFileUpload(MultipartFile multipartFile) throws IOException {
        String UPLOADED_FOLDER = "C:\\Users\\Rudolf\\Desktop\\TTN\\linksharing-master\\src\\main\\webapp\\resources\\documents";
        Path path = null;
        try {
            byte[] bytes = multipartFile.getBytes();
            path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
      //      Files.createDirectories(path.getParent());
            Files.write(path, bytes);
        } catch (Exception e) {
            System.out.println("prob in singlefileupload " + e);
        }
        return String.valueOf(path);

    }
}
