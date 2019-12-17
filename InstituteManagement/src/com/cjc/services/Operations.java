package com.cjc.services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cjc.model.Batch;
import com.cjc.model.Course;
import com.cjc.model.Faculty;
import com.cjc.model.Student;


public class Operations implements ServiceI{

	List<Course> CourseList = new ArrayList();
	List<Faculty> FacultyList = new ArrayList();
	List<Batch> BatchList = new ArrayList();
	List<Student> StudentList = new ArrayList();
	
	
	@Override
	public void addCourse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course Id : ");
		int cid = sc.nextInt();
		
		System.out.println("Enter course name : ");
		String cname = sc.next();
		
		Course c = new Course();
		c.setCname(cname);
		c.setCid(cid);
		
		CourseList.add(c);
	}
	
	@Override
	public void viewCourse()
	{
		Iterator<Course> itr = CourseList.iterator();
		
		System.out.println("Id\tCourse Name");
		while(itr.hasNext())
		{
			Course c = itr.next();
			System.out.println(c.getCid()+"\t"+c.getCname());
		}
	}
	
	@Override
	public void addFaculty()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty Id : ");
		int fid = sc.nextInt();
		System.out.println("Enter Faculty Name : ");
		String fname = sc.next();
		System.out.println("Select Course ID from below list : ");
		viewCourse();
		int cno = sc.nextInt();
		String name = null ;
		
		Iterator<Course> itr = CourseList.iterator();
		while(itr.hasNext())
		{
			Course cr = itr.next();
			if(cr.getCid() == cno)
			{
				name = cr.getCname();
				break;
			}
		}
		
		Course c = new Course();
		c.setCid(cno);
		c.setCname(name);
		
		Faculty f = new Faculty();
		f.setFid(fid);
		f.setFname(fname);
		f.setCourse(c);
		
		FacultyList.add(f);
	}
	
	public void viewFaculty()
	{
		Iterator<Faculty> itr = FacultyList.iterator();
		
		System.out.println("ID\tFaculty Name");
		while(itr.hasNext())
		{
			Faculty f = itr.next();
			System.out.println(f.getFid()+"\t"+f.getFname()+"\t"+f.getCourse().getCname());
		}
	}
	
	public void addBatch()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Id : ");
		int bid = sc.nextInt();
		System.out.println("Enter Batch Name : ");
		String bname = sc.next();
		System.out.println("Select faculty from below list : ");
		viewFaculty();
		int bno = sc.nextInt();
		String name = null;
		Course c = null ;
		
		Iterator<Faculty> itr = FacultyList.iterator();
		while(itr.hasNext())
		{
			Faculty ft = itr.next();
			if(ft.getFid() == bno)
			{
				name = ft.getFname();
				c = ft.getCourse();
				break;
			}
		}
		
		Faculty f = new Faculty();
		f.setFid(bno);
		f.setFname(name);
		f.setCourse(c);
		
		Batch b = new Batch();
		b.setFaculty(f);
		b.setBid(bid);
		b.setBname(bname);
		
		BatchList.add(b);
		
	}
	
	public void viewBatch()
	{
		
			Iterator<Batch> itr = BatchList.iterator();
			
			System.out.println("ID\tBatch Name");
			while(itr.hasNext())
			{
				Batch b = itr.next();
				System.out.println(b.getBid()+"\t"+b.getBname()+"\t"+b.getFaculty().getFname());
			}
		
	}
	
	public void addStudent()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID : ");
		int sid = sc.nextInt();
		System.out.println("Enter Student name : ");
		String sname = sc.next();
		System.out.println("Select batch from below list : ");
		viewBatch();
		int sno = sc.nextInt();
		String name = null;
		Faculty f = null;
		
		Iterator<Batch> itr = BatchList.iterator();
		while(itr.hasNext())
		{
			Batch bt = itr.next();
			if(bt.getBid() == sno)
			{
				name = bt.getBname();
				f = bt.getFaculty();
				break;
			}
		}	
		
		Batch b = new Batch();
		b.setBid(sno);
		b.setBname(name);
		b.setFaculty(f);
		
		Student s = new Student();
		s.setBatch(b);
		s.setSid(sid);
		s.setSname(sname);
		StudentList.add(s);
		
	}
	
	public void viewStudent()
	{
		
			Iterator<Student> itr = StudentList.iterator();
			
			System.out.println("ID\tBatch Name");
			while(itr.hasNext())
			{
				Student s = itr.next();
				System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getBatch().getBname());
			}
		
	}
	
}
