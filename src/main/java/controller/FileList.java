package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileList {
    @RequestMapping(value = "/fileList")
    public String queryFileList(HttpServletRequest servletRequest,Model model) {
        String ctxPath = servletRequest.getSession().getServletContext().getRealPath("/WEB-INF/file");
        if (!(ctxPath.lastIndexOf("/")==(ctxPath.length()-1))){
            ctxPath = ctxPath+"/";
        }
        File file=new File(ctxPath);
        File[] listFiles = file.listFiles();
        List<String> fileNames = new ArrayList<String>();
        for (File file1:listFiles){
            if (file1.isFile()&&(!"describe".equals(file1.getName()))){
                fileNames.add(file1.getName());
            }
        }
        model.addAttribute("files", fileNames);
        return "fileList";
    }
}
