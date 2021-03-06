package com.ysc.after.school.mobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysc.after.school.mobile.domain.db.LessonInfo;
import com.ysc.after.school.mobile.repository.LessonInfoRepository;
import com.ysc.after.school.mobile.service.LessonInfoService;

@Service
public class LessonInfoServiceImpl implements LessonInfoService {

	@Autowired
	private LessonInfoRepository lessonInfoRepository;

	@Override
	public List<LessonInfo> getList() {
		return lessonInfoRepository.findAll();
	}

	@Override
	public boolean regist(LessonInfo domain) {
		if (isNew(domain)) {
			return lessonInfoRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(LessonInfo domain) {
		if (!isNew(domain)) {
			return lessonInfoRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(LessonInfo domain) {
		lessonInfoRepository.delete(domain);
		return true;
	}

	private boolean isNew(LessonInfo domain) {
		return !lessonInfoRepository.exists(domain.getId());
	}

	@Override
	public List<LessonInfo> getList(int subjectGroupId) {
		return lessonInfoRepository.findBySubjectGroupId(subjectGroupId);
	}
}
