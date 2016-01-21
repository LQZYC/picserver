package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
public class FileDownLoadController {
    @RequestMapping("/downLoadFile/{fileName}")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        String fileName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")).substring(1);
        fileName = URLDecoder.decode(fileName, "UTF-8");
        String ctxPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file/");
        String downLoadPath = ctxPath + fileName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(downLoadPath)),
                                          headers, HttpStatus.CREATED);
    }
}
