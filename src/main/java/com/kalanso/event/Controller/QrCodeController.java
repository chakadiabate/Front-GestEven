package com.kalanso.event.Controller;

import com.kalanso.event.Model.Ticket;
import com.kalanso.event.Service.QRCodeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/gestEvent/QrCode")
@CrossOrigin(origins="*")
@RestController
@AllArgsConstructor
public class QrCodeController {

    private QRCodeService qrCodeService;


    /*@GetMapping("/fileSystem/image")
    public ResponseEntity<?> downloadImageFromFileSystem(@RequestParam String fileName) throws IOException {
        byte[] imageData=qrCodeService.GetQrCodeImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }*/

    @GetMapping("/fileSystem/{email}/List")
    public List<Ticket> GetQrCodeName(@RequestParam Long id, @PathVariable String email) {
        return qrCodeService.GetQrCodeName(id, email);
    }

    @GetMapping("/fileSystem/Lists")
    public List<Ticket> getAll(){
        return qrCodeService.getAll();
    }

    @PatchMapping("/changeStatut/{id}")
    public Ticket changeStatuts(@PathVariable Long id){
        return qrCodeService.changeStatus(id);
    }
}
