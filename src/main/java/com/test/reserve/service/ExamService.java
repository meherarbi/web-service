package com.test.reserve.service;

import com.test.reserve.databaseTest.dataTest;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamListResponse;
import de.tekup.soap.models.whitetest.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {

  public ExamListResponse TestExam(){
      ExamListResponse examListResponse = new ObjectFactory().createExamListResponse();
      List<Exam> examsResponse = examListResponse.getExamList();
      List<Exam> exams = dataTest.listOfExam;
             exams.stream()
             .filter(x->x.isDisponible())
             .forEach(x->examsResponse.add(x));
      return examListResponse;

  }



}
