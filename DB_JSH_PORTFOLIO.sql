-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.4.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- jsh_portfolio 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jsh_portfolio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jsh_portfolio`;

-- 테이블 jsh_portfolio.log 구조 내보내기
CREATE TABLE IF NOT EXISTS `log` (
  `LogId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `LogUserName` varchar(255) NOT NULL,
  `LogRegDate` datetime NOT NULL COMMENT '�벑濡� �궇吏�',
  `LogContent` varchar(8000) NOT NULL DEFAULT '' COMMENT '濡쒓렇 �궡�슜',
  `IpAddress` varchar(255) NOT NULL,
  `LogInHit` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`LogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jsh_portfolio.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `NoticeId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NoticeUserName` varchar(255) NOT NULL,
  `NoticeTitle` varchar(300) NOT NULL DEFAULT '' COMMENT '�젣紐�',
  `NoticeContent` varchar(8000) NOT NULL DEFAULT '' COMMENT '�궡�슜',
  `NoticeRegDate` datetime NOT NULL COMMENT '�벑濡� �궇吏�',
  PRIMARY KEY (`NoticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jsh_portfolio.qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `qna` (
  `QnaId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `QnaUserName` varchar(255) NOT NULL,
  `QnaQuestion` varchar(1000) NOT NULL DEFAULT '' COMMENT '吏덈Ц',
  `QnaAnswer` varchar(8000) NOT NULL DEFAULT '' COMMENT '�떟蹂�',
  `QnaRegDate` datetime NOT NULL COMMENT '�벑濡� �궇吏�',
  PRIMARY KEY (`QnaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jsh_portfolio.userboard 구조 내보내기
CREATE TABLE IF NOT EXISTS `userboard` (
  `bId` bigint(20) NOT NULL AUTO_INCREMENT,
  `bUserName` varchar(255) NOT NULL,
  `bTitle` varchar(200) NOT NULL,
  `bContent` varchar(300) NOT NULL,
  `bHit` int(20) NOT NULL,
  `bRegDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`bId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jsh_portfolio.users 구조 내보내기
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isAdmin` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jsh_portfolio.usersinfo 구조 내보내기
CREATE TABLE IF NOT EXISTS `usersinfo` (
  `infoId` bigint(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  PRIMARY KEY (`infoId`),
  CONSTRAINT `usersinfo_ibfk_1` FOREIGN KEY (`infoId`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
