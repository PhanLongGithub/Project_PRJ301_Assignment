use AttendanceTakingSystem
go

SELECT [CampusName]
FROM [dbo].[Campus]

SELECT [SessionID]
 ,[GroupID]
 ,s.[LecturersID]
 ,[CourseID]
 ,s.[SlotID]
 ,t.SlotNumber
 ,t.TimeFrom
 ,t.TimeTo
 ,[Room]
 ,[SlotStatus]
 FROM [dbo].[Session] s
 LEFT JOIN [dbo].[TimeSlot] t on t.[SlotID] = s.[SlotID]
 LEFT JOIN [dbo].Lecturers l on l.LecturersID = s.LecturersID
 WHERE t.TimeFrom >= '2022-06-20' and t.TimeFrom <= '2022-06-26' and s.[LecturersID] like 'lantt' and l.CampusID like '3'

 --Attendance
 SELECT [SessionID]
 ,[GroupID]
 ,s.[LecturersID]
 ,[CourseID]
 ,s.[SlotID]
 ,t.SlotNumber
 ,t.TimeFrom
 ,t.TimeTo
 ,[Room]
 ,[SlotStatus]
 FROM [dbo].[Session] s
 LEFT JOIN [dbo].[TimeSlot] t on t.[SlotID] = s.[SlotID]
 LEFT JOIN [dbo].Lecturers l on l.LecturersID = s.LecturersID
 WHERE t.TimeFrom >= '2022-06-20' and t.TimeFrom <= '2022-06-26' and s.[LecturersID] like 'longpt01' and l.CampusID like '1'
 and GroupID like 'SE1630'

 INSERT INTO [dbo].[Attendance]
           ([StudentsID]
           ,[SessionID]
           ,[Commet]
           ,[Status]
           ,[RecordTime])
     VALUES
           (?
           ,?
           ,?
           ,?
           ,?)

SELECT se.GroupID,
     st.StudentsFirstName,
	 st.StudentsMiddleName,
	 st.StudentsLastName,
	 st.StudentsImage,
	 a.Commet,
	 se.LecturersID,
	 a.[Status],
	 a.RecordTime
 FROM [dbo].[Attendance] a
 JOIN [dbo].[Session] se 
 on a.SessionID = se.SessionID
 JOIN [dbo].Students st
 on a.StudentsID = st.StudentsID
 Where se.SessionID like '1'

 SELECT se.GroupID,
     st.StudentsID,
	 st.StudentsFirstName,
	 st.StudentsMiddleName,
	 st.StudentsLastName,
	 se.LecturersID,
	 se.CourseID,
	 se.SlotID,
	 se.Room,
	 se.SlotStatus
 FROM [dbo].StudentGroup sg
 JOIN [dbo].[Session] se 
 on sg.GroupID = se.GroupID
 JOIN [dbo].Students st
 on sg.StudentsID = st.StudentsID
 Where se.SessionID like '1'

 DBCC CHECKIDENT ('Session', RESEED, 3);