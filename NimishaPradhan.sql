-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for cms
CREATE DATABASE IF NOT EXISTS `cms` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `cms`;

-- Dumping structure for table cms.admins
CREATE TABLE IF NOT EXISTS `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT 'none',
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.admins: ~0 rows (approximately)
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` (`id`, `fullname`, `gender`, `phone`, `address`, `username`, `email`, `password`, `updatedOn`) VALUES
	(1, 'Nimisha Pradhan', 'Female', '9849372055', 'New Baneshwor, Kathmandu', 'azrael', 'pradhan.nimi13@gmail.com', 'Nimishapradhan1', '2023-02-09 17:03:20');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;

-- Dumping structure for table cms.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT 'none',
  `year` int(11) DEFAULT 1,
  `isActive` int(11) DEFAULT 0,
  `updatedOn` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.courses: ~1 rows (approximately)
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `name`, `year`, `isActive`, `updatedOn`) VALUES
	(1, 'BIT', 3, 1, '2023-02-09 17:04:30'),
	(2, 'BIBM', 4, 1, '2023-02-09 17:04:27');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;

-- Dumping structure for table cms.enrolled_module_instructors
CREATE TABLE IF NOT EXISTS `enrolled_module_instructors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instructors` varchar(50) DEFAULT 'none',
  `phone` varchar(50) DEFAULT 'none',
  `address` varchar(50) DEFAULT 'none',
  `email` varchar(50) DEFAULT 'none',
  `semester` varchar(50) DEFAULT 'none',
  `level` varchar(50) DEFAULT 'none',
  `module` varchar(50) DEFAULT 'none',
  `course` varchar(50) DEFAULT 'none',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.enrolled_module_instructors: ~0 rows (approximately)
/*!40000 ALTER TABLE `enrolled_module_instructors` DISABLE KEYS */;
INSERT INTO `enrolled_module_instructors` (`id`, `instructors`, `phone`, `address`, `email`, `semester`, `level`, `module`, `course`) VALUES
	(101, 'Pankaj Niraula', '221', 'Naxal, Kathmandu', 'pankaj@gmail.com', '1', '4', 'Internet Software Architecture', 'BIT'),
	(102, 'Rohit Parajuli', '223', 'Naxal,kathmandu', 'rohit@gmail.com', '1', '4', 'Academics', 'BIT'),
	(103, 'Anmol Adhikari', '224', 'Imadol, Kathmandu', 'anmol@gmail.com', '1', '4', 'Colborative Development', 'BIT'),
	(104, 'Prabin Sapkota', '225', 'Dhobighat, Kathmandu', 'prabin@gmail.com', '1', '4', 'Distributed System', 'BIT'),
	(105, 'Basudeo Shrestha', '226', 'Dattatrya, Bhaktapur', 'basudeo@gmail.com', '2', '4', 'Database', 'BIT'),
	(106, 'Rukesh Shrestha', '227', 'Koteshwor, Kathmandu', 'rukesh@gmail.com', '2', '4', 'Numerical Methods', 'BIT'),
	(107, 'Subash Bista', '228', 'Tinkune, Kathmandu', 'subash@gmail.com', '2', '4', 'Embeded System', 'BIT'),
	(108, 'Jenny Rajak', '229', 'Santinagar, Kathmandu', 'jenny@gmail.com', '2', '4', 'Big Data', 'BIT'),
	(109, 'Jeshmi Rajak', '230', 'Gangabu, Kathmandu', 'jeshmi@gmail.com', '1', '5', 'Project and Professionalism', 'BIT'),
	(110, 'Aashish Acharya', '231', 'Thamel, Kathmandu', 'aasish@gmail.com', '1', '5', 'Introductory Programming', 'BIT'),
	(111, 'Simon Giri', '231', 'Maitighar, Kathmandu', 'simon@gmail.com', '1', '5', 'Computational Mathematics', 'BIT'),
	(112, 'Ronit Shrestha', '232', 'Jhamsikhel, Kathmandu', 'ronit@gmail.com', '1', '5', 'Web Technologies', 'BIT'),
	(113, 'Uttam Acharya', '233', 'Lagankhel, Kathmandu', 'uttam@gmail.com', '2', '5', 'Human Computer Interaction', 'BIT'),
	(114, 'Ayush Shrestha', '234', 'Pulchowk, Lalitpur', 'ayush@gmail.com', '2', '5', 'Graphical designing', 'BIT'),
	(115, 'Pravash Sapkota', '235', 'Patan, Lalitpur', 'pravash@gmail.com', '2', '5', 'Data Programming', 'BIT'),
	(116, 'Tara Subedi', '236', 'Thamel, Kathmandu', 'tara@gmail.com', '2', '5', 'Game Development', 'BIT'),
	(117, 'Raunak Karmacharya', '237', 'Jamal, Kathmandu', 'raunak@gmail.com', '1', '6', 'Applied Machine Learning', 'BIT'),
	(118, 'Anshu Lama', '238', 'Baneshwor, Kathmandu', 'anshu@gmail.com', '1', '6', 'Python Programming', 'BIT'),
	(119, 'Manil Limbu', '239', 'Balaju, Kathmandu', 'manil@gmail.com', '1', '6', 'Emerging Interactive Technologies', 'BIT'),
	(120, 'Sarada Paudel', '240', 'Baneshowr, Kathmandu', 'sarada@gmail.com', '1', '6', 'Advance Web Technologies', 'BIT'),
	(121, 'Aagya Sharma', '241', 'Maitidevi, Kathmandu', 'aagya@gmail.com', '2', '6', 'Computational Neuroscience', 'BIT'),
	(122, 'Smarika Shrestha', '242', 'Gothatar, Kathmandu', 'smarika@gmail.com', '2', '6', 'Robotics', 'BIT'),
	(123, 'Diya Shrestha', '243', 'Sinamangal, Kathmandu', 'diya@gmail.com', '2', '6', 'Data Frameworks', 'BIT'),
	(124, 'Aashish Limbu', '244', 'Budanilkantha, Kathmandu', 'aashish@gmail.com', '2', '6', 'High Performance Computing', 'BIT');
/*!40000 ALTER TABLE `enrolled_module_instructors` ENABLE KEYS */;

-- Dumping structure for table cms.enrolled_module_students
CREATE TABLE IF NOT EXISTS `enrolled_module_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` varchar(50) DEFAULT 'none',
  `phone` varchar(50) DEFAULT 'none',
  `address` varchar(50) DEFAULT 'none',
  `email` varchar(50) DEFAULT 'none',
  `semester` varchar(50) DEFAULT 'none',
  `level` varchar(50) DEFAULT 'none',
  `module1` varchar(50) DEFAULT 'none',
  `module2` varchar(50) DEFAULT 'none',
  `module3` varchar(50) DEFAULT 'none',
  `module4` varchar(50) DEFAULT 'none',
  `module5` varchar(50) DEFAULT 'none',
  `module6` varchar(50) DEFAULT 'none',
  `instructors` varchar(50) DEFAULT 'none',
  `course` varchar(50) DEFAULT 'none',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2065925 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.enrolled_module_students: ~0 rows (approximately)
/*!40000 ALTER TABLE `enrolled_module_students` DISABLE KEYS */;
INSERT INTO `enrolled_module_students` (`id`, `student`, `phone`, `address`, `email`, `semester`, `level`, `module1`, `module2`, `module3`, `module4`, `module5`, `module6`, `instructors`, `course`) VALUES
	(920, 'Lujana Bajracharya', '01234', 'Sigal,Kathmandu', 'lujana@gmail.com', 'none', '2', 'Embeded System', 'Game Development', 'Risk Insurance', 'Big Data', 'none', 'none', 'none', 'none'),
	(921, 'Madan Khanal', '02234', 'Baneshwor, Kathmandu', 'madan@gmail.com', 'none', '1', 'Internet Software Architecture', 'Distributed System', 'Collaborative Development', 'Academics', 'none', 'none', 'none', 'none'),
	(923, 'Pasang Sherpa', '03344', 'Kapan, Kathmandu', 'pasanga@gmail.com', 'none', '2', 'Graphical Designing', 'Web Development', 'Human Computer Interaction', 'Data Programming', 'none', 'none', 'none', 'none'),
	(924, 'Manoj Karki', '05544', 'Kalanki, Kathmandu', 'manoj@gmail.com', 'none', '1', 'Computational Mathematics', 'Web Technologies', 'Introductory Programming', 'Project and Professionalism', 'none', 'none', 'none', 'none'),
	(931, 'Dhiraj Shah', '06644', 'Pepsicola, Kathmandu', 'dhiraj@gmail.com', 'none', '1', 'Advance Web Technologies', 'Applied Machine Learning', 'Emerging Interactive Technologies', 'Python Programming', 'Digital Marketing', 'General Marketing', 'none', 'none'),
	(932, 'Saurav Niraula', '07744', 'Sukedhara, Kathmandu', 'saurav@gmail.com', 'none', '2', 'Robotics', 'Data Frameworks', 'High Performance Computing', 'Computational Neuroscience', 'Risk Management', 'none', 'none', 'none');
/*!40000 ALTER TABLE `enrolled_module_students` ENABLE KEYS */;

-- Dumping structure for table cms.instructors
CREATE TABLE IF NOT EXISTS `instructors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT 'none',
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.instructors: ~0 rows (approximately)
/*!40000 ALTER TABLE `instructors` DISABLE KEYS */;
INSERT INTO `instructors` (`id`, `fullname`, `gender`, `phone`, `address`, `username`, `email`, `password`, `updatedOn`) VALUES
	(1, 'Pankaj Niraula', 'Male', '321', ', Kathmandu', 'pankaj1', 'pankaj@gmail.com', '123', '2023-02-09 17:55:34'),
	(2, 'Anmol Adhikari', 'Male', '421', 'Kalanki, Kathmandu', 'anmol1', 'anmol@gmail.com', '456', '2023-02-09 17:55:37'),
	(3, 'Subash Bista', 'Male', '542', 'Sukedhara, Kathmandu', 'subash1', 'subash@gmail.com', '789', '2023-02-09 17:55:40'),
	(4, 'Ayush Shrestha', 'Male', '654', 'Patan, Lalitpur', 'ayush1', 'ayush@gmail.com', '120', '2023-02-09 17:55:44');
/*!40000 ALTER TABLE `instructors` ENABLE KEYS */;

-- Dumping structure for table cms.modules
CREATE TABLE IF NOT EXISTS `modules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` varchar(50) DEFAULT '0',
  `semester` varchar(50) DEFAULT '0',
  `level` varchar(50) DEFAULT '0',
  `module1` varchar(50) DEFAULT '0',
  `module2` varchar(50) DEFAULT '0',
  `module3` varchar(50) DEFAULT '0',
  `module4` varchar(50) DEFAULT '0',
  `module5` varchar(50) DEFAULT '0',
  `module6` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.modules: ~0 rows (approximately)
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` (`id`, `course`, `semester`, `level`, `module1`, `module2`, `module3`, `module4`, `module5`, `module6`) VALUES
	(1, 'BIT', '1', '4', 'Internet Software Architecture', 'Distributed System', 'Collaborative Development', 'Academics', '0', '0'),
	(2, 'BIT', '2', '4', 'Embeded System', 'Game Development', 'Risk Insurance', 'Big Data', '0', '0'),
	(3, 'BIT', '1', '5', 'Computational Mathematics', 'Web Technologies', 'Introductory Programming', 'Project and Professionalism', '0', '0'),
	(4, 'BIT', '2', '5', 'Graphical Designing', 'Web Development', 'Human Computer Interaction', 'Data Programming', '0', '0'),
	(5, 'BIT', '1', '6', 'Advance Web Technologies', 'Applied Machine Learning', 'Emerging Interactive Technologies', 'Python Programming', 'Digital Marketing', 'General Marketing'),
	(6, 'BIT', '2', '6', 'Robotics', 'Data Framework', 'High Performance Computing', 'Computational Neuroscience', 'Risk Management', '0');
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;

-- Dumping structure for table cms.result
CREATE TABLE IF NOT EXISTS `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT NULL,
  `instructor` varchar(50) DEFAULT NULL,
  `module` varchar(50) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  `marks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.result: ~0 rows (approximately)
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` (`id`, `student`, `email`, `instructor`, `module`, `semester`, `level`, `marks`) VALUES
	(1, 'Lujana Bajracharya', 'lujana@gmail.com', 'Pankaj Niraula', 'Internet Software Arctitechture', '1', '4', '60'),
	(2, 'Madan Khanal', 'madan@gmail.com', 'Rukesh Shrestha', 'Numerical Methods', '2', '4', '70'),
	(3, 'Pasang Sherpa', 'pasang@gmail.com', 'Rohit Parajuli', 'Introductory Programming', '1', '5', '80'),
	(4, 'Manoj Karki', 'manoj@gmail.com', 'Ayush Shrestha', 'Graphical Designing', '2', '5', '90'),
	(5, 'Dhiraj Shah', 'dhiraj@gmail.com', 'Sarada Paudel', 'Advance Web Technologies', '1', '6', '75'),
	(6, 'Saurav Niraula', 'saurav@gmail.com', 'Smarika Shrestha', 'Robotics', '2', '6', '95');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;

-- Dumping structure for table cms.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT 'none',
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `course` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT 'Level 4',
  `semester` varchar(50) DEFAULT 'Semester 1',
  `updatedOn` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table cms.students: ~0 rows (approximately)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `fullname`, `gender`, `phone`, `address`, `username`, `email`, `password`, `course`, `level`, `semester`, `updatedOn`) VALUES
	(1, 'Lujana Bajracharya', 'Female', '01234', 'Sigal, Kathmandu', 'luzz', 'lujana@gmail.com', 'pass1', 'BIT', 'Level 4', 'Semester 2', '2023-02-09 18:12:48'),
	(2, 'Madan Khanal', 'Male', '02234', 'Baneshwor, Kathmandu', 'sayak', 'madan@gmail.com', 'pass2', 'BIT', 'Level 4', 'Semester 1', '2023-02-09 18:12:51'),
	(3, 'Pasang Sherpa', 'Female', '03344', 'Kapan, Kathmandu', 'psherpa', 'pasang@gmail.com', 'pass3', 'BIT', 'Level 5', 'Semester 2', '2023-02-09 18:12:53'),
	(4, 'Manoj Karki', 'Male', '05544', 'Kalanki, Kathmandu', 'manyt', 'manoj@gmail.com', 'pass4', 'BIT', 'Level 5', 'Semester 1', '2023-02-09 18:12:55'),
	(5, 'Dhiraj Shah', 'Male', '06644', 'Pepsicola, Kathmandu', 'kanu', 'dhiraj@gmail.com', 'pass5', 'BIT', 'Level 6', 'Semester 2', '2023-02-09 18:12:59'),
	(6, 'Saurav Niraula', 'Male', '07744', 'Sukedhara, Kathmandu', 'sauravn', 'saurav@gmail.com', 'pass6', 'BIT', 'Level 6', 'Semester 1', '2023-02-09 18:13:02');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
