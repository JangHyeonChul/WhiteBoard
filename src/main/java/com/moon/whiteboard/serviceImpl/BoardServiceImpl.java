package com.moon.whiteboard.serviceImpl;

import com.moon.whiteboard.dto.BoardDto;
import com.moon.whiteboard.dto.FileDto;
import com.moon.whiteboard.mapper.BoardMapper;
import com.moon.whiteboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Repository
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public BoardDto getBoardDetail(long uid) {
        return boardMapper.selectBoard(uid);
    }

    // 기존의 getBoardList 메소드는 그대로 두고 새로운 메소드 두 개를 추가함
    @Override
    public List<BoardDto> getBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public int getBoardCount() {
        return boardMapper.selectBoardCount();
    }

    @Override
    public List<BoardDto> getBoardListWithPaging(int page) {
        int limit = 10; // 한 페이지당 보여줄 게시물 수
        int offset = (page - 1) * limit; // 시작 위치 계산
        return boardMapper.selectBoardListWithLimitAndOffset(limit, offset);
    }


    @Override
    public void write(BoardDto boardDto, MultipartFile[] files) throws IOException {
        log.info("페이지 글쓰기 확인 222");
        List<FileDto> fileList = new ArrayList<>();
        for(MultipartFile file : files){
            if(!file.isEmpty()){
                //파일의 실제이름
                String fileName = file.getOriginalFilename();
                //파일의 사이즈
                Long fileSize = file.getSize();
                //파일의 주소를 가져온다
                String fileUrl = "/\\upload\\/" + UUID.randomUUID() + "-" + fileName;
                //임시 파일을 생성하여 로컬 폴더에 저장한다.
                File targetFile = new File("/D:"+ fileUrl);
                //파일 변환
                file.transferTo(targetFile);
                //파일을 FileDto의 형식에 맞게 저장
                fileList.add(new FileDto(boardDto.getUid(), fileName, fileSize, fileUrl));

                try (FileInputStream fis = new FileInputStream(targetFile)) {
                    // 파일 사용
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 로컬에 저장된 임시파일 삭제구문
                    targetFile.delete();
                }
            }
        }
        boardDto.setFiles(fileList);
        boardMapper.insertBoard(boardDto);
        if(fileList.size() > 0){
            boardMapper.insertFile(fileList);
        }

    }


}
