use master
go

create database AttendanceTakingSystem

use AttendanceTakingSystem
go

create table Campus(
  CampusID int IDENTITY(1,1) primary key,
  CampusName nvarchar(50) not null
)

create table Lecturers(
  LecturersID varchar(20) primary key,
  LecturersLastName nvarchar(50),
  LecturersMiddleName nvarchar(50),
  LecturersFirstName nvarchar(50),
  LecturersEmail varchar(100) not null,
  LecturersImage varchar(max),
  CampusID int not null,
  Foreign key (CampusID) references Campus(CampusID)
)

create table Students(
  StudentsID varchar(20) primary key,
  StudentsLastName nvarchar(50),
  StudentsMiddleName nvarchar(50),
  StudentsFirstName nvarchar(50),
  StudentsEmail varchar(100) not null,
  StudentsImage varchar(max),
  CampusID int not null,
  Foreign key (CampusID) references Campus(CampusID)
)

create table Departments(
  DepartmentID int IDENTITY(1,1) primary key,
  DepartmentName varchar(50) not null,
  Term varchar(20) not null,
  CampusID int not null,
  Foreign key (CampusID) references Campus(CampusID)
)

create table Courses(
  CourseID varchar(20) primary key,
  CourseName varchar(50) not null,
  DepartmentID int not null,
  Foreign key (DepartmentID) references Departments(DepartmentID)
) 

create table Groups(
  GroupID varchar(20) primary key
)

create table StudentGroup(
  GroupID varchar(20) not null,
  StudentsID varchar(20) not null,
  Foreign key (GroupID) references Groups(GroupID),
  Foreign key (StudentsID) references Students(StudentsID)
)

create table TimeSlot(
  SlotID int IDENTITY(1,1) primary key,
  SlotNumber varchar(20) not null,
  TimeFrom datetime not null,
  TimeTo datetime not null,
  Term varchar(20) not null
)

create table [Session](
  SessionID int IDENTITY(1,1) primary key,
  GroupID varchar(20) not null,
  LecturersID varchar(20) not null,
  CourseID varchar(20) not null,
  SlotID int not null,
  Room varchar(20) not null,
  SlotStatus varchar(20) not null check(SlotStatus='Attended' or SlotStatus='Not yet')
  Foreign key (LecturersID) references Lecturers(LecturersID),
  Foreign key (CourseID) references Courses(CourseID),
  Foreign key (SlotID) references TimeSlot(SlotID),
  Foreign key (GroupID) references Groups(GroupID)
)

create table Attendance(
  StudentsID varchar(20) not null,
  SessionID int not null,
  Commet nvarchar(max) not null,
  [Status] varchar(20) not null check(Status='Present' or Status='Absent'),
  RecordTime datetime not null
  Foreign key (StudentsID) references Students(StudentsID),
  Foreign key (SessionID) references Session(SessionID)
)

