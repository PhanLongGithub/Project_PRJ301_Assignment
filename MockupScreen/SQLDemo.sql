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
 WHERE t.TimeFrom >= '2022-06-20' and t.TimeFrom <= '2022-06-26' and s.[LecturersID] like 'longpt01' and l.CampusID like '1'

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
 WHERE t.TimeFrom >= '2022-06-24' and t.TimeFrom <= '2022-06-24' and s.[LecturersID] like 'longpk01' and l.CampusID like '1'
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
 Where se.GroupID like 'SE1630' and se.LecturersID like 'longpk01' and a.RecordTime >= '2022-06-24' and a.RecordTime <= '2022-06-24'