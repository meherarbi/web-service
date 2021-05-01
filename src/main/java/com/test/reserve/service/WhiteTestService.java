package com.test.reserve.service;

import com.test.reserve.databaseTest.dataTest;
import de.tekup.soap.models.whitetest.*;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WhiteTestService {


    public WhiteTestResponse checkWhiteTest(StudentRequest studentRequest){

        WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();

        // test if the Student id  and exam code exist
        int student_id = studentRequest.getStudentId();
        String exam_code = studentRequest.getExamCode();

        List<Student> students = dataTest.listOfStudent;
        boolean test_student = students.stream().anyMatch(x->x.getId()==student_id);
        if(!test_student)
            whiteTestResponse.getCriteriaMismatch().add("this student does not exist");

        List<Exam> exams = dataTest.listOfExam;
        boolean test_exam = exams.stream().anyMatch(x->x.getCode().equals(exam_code));
        if(!test_exam)
            whiteTestResponse.getCriteriaMismatch().add("this exam does not exist");


        if(whiteTestResponse.getCriteriaMismatch().isEmpty()){
            // get list from database
            List<WhiteTestResponse> list = dataTest.listOfdata;
            // get information of the specific student and test
            for (int i = 0; i <list.size() ; i++) {
                if(list.get(i).getExam().getCode().equals(exam_code) && list.get(i).getStudent().getId()==student_id){
                    return list.get(i);
                }
            }

            // add error if the student exist and the exam also but there is no whiteTestResponse for both
            whiteTestResponse.getCriteriaMismatch().add("exam code does not joiniable for current student ");
        }
       return whiteTestResponse;

    }
}
