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

    @Override
    public int getBoardCount() {
        return boardMapper.selectBoardCount();
    }

    @Override
    public List<BoardDto> getBoardListWithPaging(int page, int pageSize) {
        int totalCount = getBoardCount(); // 총 게시물 수

        int totalPageCount = (int) Math.ceil((double) totalCount / pageSize); // 총 페이지 수

        int start = (page - 1) * pageSize; // 시작 위치

        // 페이지 번호 범위 설정
        int startPage = ((page - 1) / 5) * 5 + 1;
        int endPage = Math.min(startPage + 4, totalPageCount);

        // 이전 페이지, 다음 페이지 설정
        int prevPage = Math.max(page - 1, 1);
        int nextPage = Math.min(page + 1, totalPageCount);

        return boardMapper.selectBoardListWithLimitAndOffset(pageSize, start);
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
