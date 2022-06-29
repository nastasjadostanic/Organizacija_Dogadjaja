package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.repository.ImageRepository;
import stasaaleksadavid.isabackend.model.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    //get all

    @GetMapping("/images/{type}")
    public List<Image> getAllImages(@PathVariable String type){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
            return imageRepository.findAll();
        }
        else{return null;}
    }

    //create
    @PostMapping("/images/{type}")
    public  Image createImage(@PathVariable String type,@RequestBody Image image){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
        return imageRepository.save(image);
        }
        else{return null;}
    }

    //get by id

    @GetMapping("/images/id/{type}/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable String type,@PathVariable Long id){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {
            Image image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image does not exist with id:" + id));
            return ResponseEntity.ok(image);
        }
        else return null;

    }
    //update
    @PutMapping("/images/{type}/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable String type,@PathVariable Long id,@RequestBody Image imageDetails){

        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
            Image image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image does not exist with id:" + id));


                image.setImage1(imageDetails.getImage1());
            image.setImage2(imageDetails.getImage2());
            image.setImage3(imageDetails.getImage3());
            image.setImage4(imageDetails.getImage4());
            image.setImage5(imageDetails.getImage5());
                image.setType(imageDetails.getType());
                image.setIdOfType(imageDetails.getIdOfType());

                Image updatedImage = imageRepository.save(image);
                return ResponseEntity.ok(updatedImage);
            }
            else{return null;}
    }
    //delete
    @DeleteMapping("/images/{type}/{id}")
    public Map<String, Boolean> deleteImage(@PathVariable Long id,@PathVariable String type) {
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")){
            Image image = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image does not exist with id:" + id));

            imageRepository.delete(image);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return (Map<String, Boolean>) ResponseEntity.ok(response);
        }
        else{return null;}
    }




    //get by type and type id
    @GetMapping("/images/type/{type}/{type2}/{typeId}")
    public Image getAllImagesByType(@PathVariable String type,@PathVariable String type2,@PathVariable Long typeId){
        if(type.equals("ship_owner") || type.equals("admin")|| type.equals("cottage_owner")|| type.equals("fishing_instructor")|| type.equals("main_admin")) {
            return imageRepository.findByTypeAndIdOfType(type2,typeId);
        }
        else return null;
    }


}
