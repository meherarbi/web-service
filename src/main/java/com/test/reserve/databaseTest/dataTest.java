package com.test.reserve.databaseTest;

import de.tekup.soap.models.whitetest.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class dataTest {

 public  static List<WhiteTestResponse> listOfdata = new ArrayList<>();
 public static List<Student> listOfStudent = new ArrayList<>();
 public static List<Exam> listOfExam = new ArrayList<>();


  static {


      // create an object factory
      ObjectFactory of = new ObjectFactory();

      //create three address
      Address ad1 = of.createAddress();
      ad1.setCity("Tunis");
      ad1.setPostCode(5566);
      ad1.setStreet("tunis");
      Address ad2 = of.createAddress();
      ad2.setCity("Manouba");
      ad2.setPostCode(4433);
      ad2.setStreet("manouba");

      // create list of student
      Student s1 = of.createStudent();
      s1.setId(1);
      s1.setName("Rick");
      s1.setAddress(ad1);
      Student s2 = of.createStudent();
      s2.setId(2);
      s2.setName("Morty");
      s2.setAddress(ad2);
      Student s3 = of.createStudent();
      s3.setId(3);
      s3.setName("Marx");
      s3.setAddress(ad2);

      // create two exam
      Exam e1 = of.createExam();
      e1.setCode("1z0-808");
      e1.setName("OCA");
      e1.setDisponible(true);
      Exam e2 = of.createExam();
      e2.setCode("1z0-809");
      e2.setName("OCP");
      e2.setDisponible(true);

      // add object created to exam ans student list
      listOfExam.add(e1);
      listOfExam.add(e2);
      listOfStudent.add(s1);
      listOfStudent.add(s2);
      listOfStudent.add(s3);

      // create of three date

    XMLGregorianCalendar xmlGregorianCalendar1 = null;
      XMLGregorianCalendar xmlGregorianCalendar2=null;
      XMLGregorianCalendar xmlGregorianCalendar3=null;
      try {
           xmlGregorianCalendar1 =
                  DatatypeFactory.newInstance().newXMLGregorianCalendar();

           xmlGregorianCalendar2 =
                  DatatypeFactory.newInstance().newXMLGregorianCalendar();

          xmlGregorianCalendar3 =
                  DatatypeFactory.newInstance().newXMLGregorianCalendar();
      } catch (DatatypeConfigurationException e) {
          e.printStackTrace();
      }

        // create three instance of WhiteTestResponse
        // added it to list
      if(xmlGregorianCalendar1 != null){
          WhiteTestResponse wt1 = of.createWhiteTestResponse();
          wt1.setStudent(s1);
          wt1.setExam(e1);
          xmlGregorianCalendar1.setYear(2015);
          xmlGregorianCalendar1.setTime(11,30,15);
          xmlGregorianCalendar1.setDay(15);
          xmlGregorianCalendar1.setMonth(1);
          wt1.setDate(xmlGregorianCalendar1);
          listOfdata.add(wt1);
      }

      if(xmlGregorianCalendar2 != null){
          WhiteTestResponse wt2 = of.createWhiteTestResponse();
          wt2.setStudent(s2);
          wt2.setExam(e2);
          xmlGregorianCalendar2.setYear(2012);
          xmlGregorianCalendar2.setTime(12,28,5);
          xmlGregorianCalendar2.setDay(18);
          xmlGregorianCalendar2.setMonth(5);
          wt2.setDate(xmlGregorianCalendar2);
          listOfdata.add(wt2);
      }

      if(xmlGregorianCalendar3 != null){
          WhiteTestResponse wt3 = of.createWhiteTestResponse();
          wt3.setStudent(s3);
          wt3.setExam(e1);
          xmlGregorianCalendar3.setYear(2018);
          xmlGregorianCalendar3.setTime(12,2,5);
          xmlGregorianCalendar3.setDay(6);
          xmlGregorianCalendar3.setMonth(8);
          wt3.setDate(xmlGregorianCalendar3);
          listOfdata.add(wt3);
      }
  }

}
