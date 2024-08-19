package com.kalanso.event.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kalanso.event.Model.QrCode;
import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Model.StatutQrcode;
import com.kalanso.event.Repository.Reservation_repo;
import com.kalanso.event.Repository.StatutQrcode_repo;
import com.kalanso.event.Repository.qrCode_repo;
import com.kalanso.event.Service.Notification.GenerateRandomString;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class QRCodeService {

    private Reservation_repo reservationRepo;
    private qrCode_repo qrCode_repo;
    private StatutQrcode_repo statutQrcodeRepo;
    private GenerateRandomString generateRandomString;

    public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        javax.imageio.ImageIO.write(bufferedImage, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

    public void StoreQrCode(Reservation reservation) throws WriterException, IOException {
        Reservation reservation1 = reservationRepo.findById(reservation.getId()).get();

        String qrCodeText = "http://localhost:8080/gestEvent/reservation/AfficherReservation/"+reservation1.getId()+"";

        byte[] qrCodeImage = generateQRCode(qrCodeText, 125, 125);
        String qrCodeFilePath = "D:\\GestEvent_SRC1\\" + reservation1.getId() + ".png"; // Remplacez par le chemin de votre dossier
        Files.write(Paths.get(qrCodeFilePath), qrCodeImage);

        StatutQrcode statutQrcode = statutQrcodeRepo.findByStatut("ACTIF");
        String random = generateRandomString.generateRandomString();
        QrCode qrCode = QrCode.builder()
                .nameFile("" + reservation1.getId() + ".png")
                .reservation(reservation)
                .filepath(qrCodeFilePath)
                .statutQrcode(statutQrcode)
                .ticketId(random)
                .build();
        qrCode_repo.save(qrCode);
    }

    /*public byte[] GetQrCode(String fileName) throws IOException {
        //System.out.println("filePath");
        Optional<QrCode> qrCode = qrCode_repo.findByNameFile(fileName);
        //System.out.println(qrCode);
        String filePath = qrCode.get().getFilepath();
        // System.out.println(filePath);
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image; // or handle as appropriate
    }*/

    public byte[] GetQrCodeImage(String fileName) throws IOException {
        String path = qrCode_repo.findByNameFile(fileName).getFilepath();
        System.out.println(path);
        return Files.readAllBytes(new File(path).toPath());
    }

    public List<QrCode> GetQrCodeName(Long id, String email) {
        return qrCode_repo.findTickets(id, email);
    }

    public List<QrCode> getAll(){
        return qrCode_repo.findAll();
    }
}
