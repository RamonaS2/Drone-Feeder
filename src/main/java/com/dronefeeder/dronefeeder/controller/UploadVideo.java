package com.dronefeeder.dronefeeder.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dronefeeder.dronefeeder.model.Video;

/*** Controller de Upload de Vídeos. ***/
@RestController
@RequestMapping("/videos")
public class UploadVideo {
  
  /*** Upload de um vídeo. ***/
  @PostMapping
  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    try {
      // Salva o arquivo no diretório "uploads"
      file.transferTo(new File("uploads/" + file.getOriginalFilename()));
      return ResponseEntity.ok("Upload realizado com sucesso!");
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
              "Erro ao realizar upload de vídeo: " + e.getMessage());
    }
  }
  
  /*** Buscar todos os vídeos. ***/
  @GetMapping
  public ResponseEntity<List<Video>> listarVideos() {
    File diretorio = new File("uploads");
    
    if (!diretorio.exists()) {
      diretorio.mkdir();
    }
     
    File[] arquivos = diretorio.listFiles();
    List<Video> videos = new ArrayList<>();

    for (File arquivo : arquivos) {
      String nome = arquivo.getName();
      Video video = new Video(nome);
      videos.add(video);
    }

    return ResponseEntity.ok(videos);
  }
  
  /*** Baixar um vídeo. ***/
  @GetMapping("/{nome}")
  public ResponseEntity<Resource> baixarVideo(@PathVariable String nome) {
    File arquivo = new File("uploads/" + nome);

    if (arquivo.exists()) {
      Resource resource = new FileSystemResource(arquivo);
      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + nome + "\"")
              .body(resource);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
