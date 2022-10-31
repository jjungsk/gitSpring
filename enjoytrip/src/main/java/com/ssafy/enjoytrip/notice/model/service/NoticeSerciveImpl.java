package com.ssafy.enjoytrip.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.notice.model.mapper.NoticeMapper;
import com.ssafy.enjoytrip.util.SizeConstant;

@Service
public class NoticeSerciveImpl implements NoticeService {

	private NoticeMapper noticeMapper;
	
	private NoticeSerciveImpl (NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}
	
	@Override
	public int countArticle() throws Exception {
		return noticeMapper.countArticle();
	}


	@Override
	public List<NoticeDto> listArticle(Map<String, String> map) throws Exception {
		int pgno = Integer.parseInt(map.get("pgno"));
		int spl = SizeConstant.SIZE_PER_LIST;
		int start = (pgno - 1) * spl;
		map.put("start", start + "");
		map.put("spl", spl + "");
		return noticeMapper.listArticle(map);
	}

	@Override
	public List<NoticeDto> preview(int num) throws Exception {
		return noticeMapper.preview(num);
	}

	@Override
	public int writeArticle(NoticeDto noticeDto) throws Exception {
		return noticeMapper.writeArticle(noticeDto);
	}
	
	@Override
	public NoticeDto getArticle(int articleNo) throws Exception {
		return noticeMapper.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		noticeMapper.updateHit(articleNo);
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		noticeMapper.deleteArticle(articleNo);
	}

	@Override
	public void modifyArticle(NoticeDto noticeDto) throws Exception {
		noticeMapper.modifyArticle(noticeDto);
	}


}
