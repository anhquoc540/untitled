import Filter.FilterOfRequest;
import model.Region;
import model.Request;
import utils.Function;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class   Main {
    public static void main(String[] args) throws ParseException {
        FilterOfRequest filter = new FilterOfRequest();
        float rate = 90.0f/100.0f ;
        List<Region> list1 = new ArrayList<>();
        List<Region> list2 = new ArrayList<>();
        List<Region> list3 = new ArrayList<>();
        list1.add(new Region(1,"Quan 1"));
        list1.add(new Region(1,"Quan 5"));
        list1.add(new Region(1,"Quan 2"));


        list2.add(new Region(1,"Quan 1"));
        list2.add(new Region(1,"Quan 5"));
        list2.add(new Region(1,"Quan 2"));




        /*list3.add(new Region(1,"Quan 1"));
        list3.add(new Region(1,"Quan 3"));
        list3.add(new Region(1,"Quan 2"));
        list3.add(new Region(1,"Quan Binh Thanh"));
        list3.add(new Region(1,"Quan Binh Tan"));
        list3.add(new Region(1,"Quan 12"));
        list3.add(new Region(1,"Quan 7"));
        list3.add(new Region(1,"Quan Go Vap"));*/


        Request rq1 = new Request(1,list1);
        Request rq2 = new Request(1,list2);
        //Request rq3 = new Request(1,list3);
        double distance12 = Function.minDistanceOf2Objects(rq1,rq2);
        //double distance13 = Function.minDistanceOf2Objects(rq1,rq3);
       // double distance23 = Function.minDistanceOf2Objects(rq2,rq3);
        System.out.println("distance 1 & 2 : " + distance12);
       /// System.out.println("distance 1 & 3 : " + distance13);
       // System.out.println("distance 2 & 3 : " + distance23);

      //  System.out.println(rq3.getRegions().size()*rate);


       if (filter.filterRegion(rq1,rq2)){
           System.out.println("distance 1 & 2 : Match ");
       }else{
           System.out.printf("distance 1 & 2 : Not Match  \n");
       }

      /*  if (filter.filterRegion(rq1,rq3)){
            System.out.println("distance 1 & 3 : Match  \n");
        }else{
            System.out.printf("distance 1 & 3 : Not Match \n");
        }

        if (filter.filterRegion(rq2,rq3)){
            System.out.println("distance 2 & 3 : Match  \n");
        }else{
            System.out.printf("distance 2 & 3 : Not Match  \n");
        }*/

        /* Request rq1 =  new Request(1,"07:00:00","10:00:00");
        Request rq2 =  new Request(2,"09:00:00","12:00:00");
        Date dateStartTime1 = Function.convertTime(rq1.getStart_time());
        Date dateStartTime2 = Function.convertTime(rq2.getStart_time());
        Date dateEndTime1 = Function.convertTime(rq1.getEnd_time());
        Date dateEndTime2 = Function.convertTime(rq2.getEnd_time());

        if (filter.filterTime(rq1,rq2)){
            System.out.println("distance 1 & 2 : Match  \n");
        }else{
            System.out.printf("distance 1 & 2 : Not Match  \n");
        }*/
    }
}