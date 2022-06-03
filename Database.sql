use master

create database AttendanceTakingSystem

use AttendanceTakingSystem

create table Lecturers(
  LecturersID varchar(20) primary key,
  LecturersName varchar(50) not null,
  LecturersEmail varchar(100) not null,
  LecturersImage varchar(max) not null
)

create table Students(
  StudentsID varchar(20) primary key,
  StudentsName varchar(50) not null,
  StudentsEmail varchar(100) not null,
  StudentsImage varchar(max) not null
)

create table Departments(
  DepartmentID varchar(20) primary key,
  DepartmentName varchar(50) not null,
  Term varchar(20) not null,
  Campus varchar(20) not null
)

create table Courses(
  CourseID varchar(20) primary key,
  CourseName varchar(50) not null,
  DepartmentID varchar(20) not null,
  Foreign key (DepartmentID) references Departments(DepartmentID)
) 

create table Slot(
  SlotID varchar(20) primary key,
  SlotNumber varchar(20) not null,
  TimeFrom datetime not null,
  TimeTo datetime not null,
  Term varchar(20) not null
)

create table SlotDetail(
  SlotID varchar(20) not null,
  LecturersID varchar(20) not null,
  Class varchar(20) not null,
  CourseID varchar(20) not null,
  [Location] varchar(20) not null,
  SlotStatus varchar(20) not null check(SlotStatus='Attended' or SlotStatus='Not yet')
  Foreign key (SlotID) references Slot(SlotID),
  Foreign key (LecturersID) references Lecturers(LecturersID),
  Foreign key (CourseID) references Courses(CourseID)
)

create table Attendance(
  StudentsID varchar(20) not null,
  SlotID varchar(20) not null,
  [Status] varchar(20) not null check(Status='Present' or Status='Absent')
  Foreign key (StudentsID) references Students(StudentsID),
  Foreign key (SlotID) references Slot(SlotID)
)