-- 부제
ALTER TABLE `BIT_TITLE`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_TITLE`; -- 그룹 -> 부제

-- COMMENTS
ALTER TABLE `BIT_COMMENTS`
	DROP FOREIGN KEY `FK_BIT_CONTENT_TO_BIT_COMMENTS`; -- 게시글 -> COMMENTS

-- 게시글
ALTER TABLE `BIT_CONTENT`
	DROP FOREIGN KEY `FK_BIT_TITLE_TO_BIT_CONTENT`; -- 부제 -> 게시글

-- 게시글
ALTER TABLE `BIT_CONTENT`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_CONTENT`; -- 그룹 -> 게시글

-- 그룹에 속한 회원
ALTER TABLE `BIT_GROUP_MEMBERS`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_GROUP_MEMBERS`; -- 그룹 -> 그룹에 속한 회원

-- 그룹에 속한 회원
ALTER TABLE `BIT_GROUP_MEMBERS`
	DROP FOREIGN KEY `FK_BIT_MEMBERS_TO_BIT_GROUP_MEMBERS`; -- 회원 -> 그룹에 속한 회원

-- ToolTip
ALTER TABLE `TOOLTIP`
	DROP FOREIGN KEY `FK_BIT_MEMBERS_TO_TOOLTIP`; -- 회원 -> ToolTip

-- 게시글 읽음여부
ALTER TABLE `BIT_READORNOT`
	DROP FOREIGN KEY `FK_BIT_CONTENT_TO_BIT_READORNOT`; -- 게시글 -> 게시글 읽음여부

-- MESSAGE
ALTER TABLE `BIT_MESSAGE`
	DROP FOREIGN KEY `FK_BIT_MEMBERS_TO_BIT_MESSAGE`; -- 회원 -> MESSAGE

-- MESSAGE
ALTER TABLE `BIT_MESSAGE`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_MESSAGE`; -- 그룹 -> MESSAGE

-- FILES
ALTER TABLE `BIT_FILES`
	DROP FOREIGN KEY `FK_BIT_FILE_FOLDER_TO_BIT_FILES`; -- New Table5 -> FILES

-- 공지
ALTER TABLE `BIT_ANNOUNCE`
	DROP FOREIGN KEY `FK_BIT_LEADER_WRITE_TO_BIT_ANNOUNCE`; -- 리더 -> 공지

-- 데이터
ALTER TABLE `BIT_DATA`
	DROP FOREIGN KEY `FK_BIT_LEADER_WRITE_TO_BIT_DATA`; -- 리더 -> 데이터

-- 리더
ALTER TABLE `BIT_LEADER_WRITE`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_LEADER_WRITE`; -- 그룹 -> 리더

-- 초대
ALTER TABLE `INVITATION`
	DROP FOREIGN KEY `FK_BIT_MESSAGE_TO_INVITATION`; -- MESSAGE -> 초대

-- 초대
ALTER TABLE `INVITATION`
	DROP FOREIGN KEY `FK_BIT_MEMBERS_TO_INVITATION`; -- 회원 -> 초대

-- New Table5
ALTER TABLE `BIT_FILE_FOLDER`
	DROP FOREIGN KEY `FK_BIT_CONTENT_TO_BIT_FILE_FOLDER`; -- 게시글 -> New Table5

-- 게시글 위키 답변
ALTER TABLE ` BIT_CONTENT_COLLABORATORS`
	DROP FOREIGN KEY `FK_BIT_CONTENT_TO_ BIT_CONTENT_COLLABORATORS`; -- 게시글 -> 게시글 위키 답변

-- 새 테이블2
ALTER TABLE `BIT_GROUP_REPOSITORY`
	DROP FOREIGN KEY `FK_BIT_GROUP_TO_BIT_GROUP_REPOSITORY`; -- 그룹 -> 새 테이블2

-- 회원
DROP TABLE IF EXISTS `BIT_MEMBERS` RESTRICT;

-- 그룹
DROP TABLE IF EXISTS `BIT_GROUP` RESTRICT;

-- 부제
DROP TABLE IF EXISTS `BIT_TITLE` RESTRICT;

-- COMMENTS
DROP TABLE IF EXISTS `BIT_COMMENTS` RESTRICT;

-- 게시글
DROP TABLE IF EXISTS `BIT_CONTENT` RESTRICT;

-- 그룹에 속한 회원
DROP TABLE IF EXISTS `BIT_GROUP_MEMBERS` RESTRICT;

-- ToolTip
DROP TABLE IF EXISTS `TOOLTIP` RESTRICT;

-- 게시글 읽음여부
DROP TABLE IF EXISTS `BIT_READORNOT` RESTRICT;

-- MESSAGE
DROP TABLE IF EXISTS `BIT_MESSAGE` RESTRICT;

-- FILES
DROP TABLE IF EXISTS `BIT_FILES` RESTRICT;

-- 공지
DROP TABLE IF EXISTS `BIT_ANNOUNCE` RESTRICT;

-- 데이터
DROP TABLE IF EXISTS `BIT_DATA` RESTRICT;

-- 리더
DROP TABLE IF EXISTS `BIT_LEADER_WRITE` RESTRICT;

-- 초대
DROP TABLE IF EXISTS `INVITATION` RESTRICT;

-- New Table5
DROP TABLE IF EXISTS `BIT_FILE_FOLDER` RESTRICT;

-- 게시글 위키 답변
DROP TABLE IF EXISTS ` BIT_CONTENT_COLLABORATORS` RESTRICT;

-- 새 테이블2
DROP TABLE IF EXISTS `BIT_GROUP_REPOSITORY` RESTRICT;

-- 회원
CREATE TABLE `BIT_MEMBERS` (
	`MNO`     INTEGER     NOT NULL COMMENT '회원ID', -- 회원ID
	`EMAIL`   VARCHAR(30) NOT NULL COMMENT '이메일', -- 이메일
	`PWD`     VARCHAR(50) NOT NULL COMMENT '암호', -- 암호
	`GIT_ID`  VARCHAR(50) NOT NULL COMMENT '기트아이디', -- 기트아이디
	`GIT_PWD` VARCHAR(50) NOT NULL COMMENT '기드비번', -- 기드비번
	`NAME`    VARCHAR(50) NOT NULL COMMENT '이름' -- 이름
)
COMMENT '회원';

-- 회원
ALTER TABLE `BIT_MEMBERS`
	ADD CONSTRAINT `PK_BIT_MEMBERS` -- 회원 기본키
		PRIMARY KEY (
			`MNO` -- 회원ID
		);

ALTER TABLE `BIT_MEMBERS`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원ID';

-- 그룹
CREATE TABLE `BIT_GROUP` (
	`GROUPNO`      INTEGER      NOT NULL COMMENT '그룹고유id', -- 그룹고유id
	`GROUPNAME`    VARCHAR(50)  NOT NULL COMMENT '클래스 이름', -- 클래스 이름
	`CODE`         VARCHAR(50)  NULL     COMMENT '코드', -- 코드
	`LINK`         VARCHAR(255) NULL     COMMENT '링크', -- 링크
	`INTRODUCE`    VARCHAR(255) NULL     COMMENT '소개글', -- 소개글
	`KEYWORD`      VARCHAR(255) NULL     COMMENT '키워드', -- 키워드
	`CREATED_DATE` TIMESTAMP    NULL     COMMENT '그룹생성일', -- 그룹생성일
	`CREATOR`      INTEGER      NULL     COMMENT '그룹생성자', -- 그룹생성자
	`ACTIVEGROUP`  BOOLEAN      NULL     COMMENT '활성화여부' -- 활성화여부
)
COMMENT '그룹';

-- 그룹
ALTER TABLE `BIT_GROUP`
	ADD CONSTRAINT `PK_BIT_GROUP` -- 그룹 기본키
		PRIMARY KEY (
			`GROUPNO` -- 그룹고유id
		);

ALTER TABLE `BIT_GROUP`
	MODIFY COLUMN `GROUPNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '그룹고유id';

-- 부제
CREATE TABLE `BIT_TITLE` (
	`TITLENO`      INTEGER     NOT NULL COMMENT '부제ID', -- 부제ID
	`NAME`         VARCHAR(50) NOT NULL COMMENT '부제이름 ex) 과제1, 과제2, 최종', -- 부제이름 ex) 과제1, 과제2, 최종
	`ACTIVATE`     BOOLEAN     NULL     COMMENT '게시글활성화여부', -- 게시글활성화여부
	`GROUPNO`      INTEGER     NOT NULL COMMENT '그룹고유id', -- 그룹고유id
	`CREATED_DATE` TIMESTAMP   NULL     COMMENT '생성일', -- 생성일
	`MNO`          INTEGER     NULL     COMMENT '회원ID' -- 회원ID
)
COMMENT '부제';

-- 부제
ALTER TABLE `BIT_TITLE`
	ADD CONSTRAINT `PK_BIT_TITLE` -- 부제 기본키
		PRIMARY KEY (
			`TITLENO` -- 부제ID
		);

ALTER TABLE `BIT_TITLE`
	MODIFY COLUMN `TITLENO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '부제ID';

-- COMMENTS
CREATE TABLE `BIT_COMMENTS` (
	`COMMENTNO`    INTEGER      NOT NULL COMMENT '댓글id', -- 댓글id
	`GROUPNO`      INTEGER      NULL     COMMENT '그룹id', -- 그룹id
	`CONTENT`      VARCHAR(255) NULL     COMMENT '댓글내용', -- 댓글내용
	`MEMNO`        INTEGER      NULL     COMMENT '작성자', -- 작성자
	`CREATED_DATE` TIMESTAMP    NULL     COMMENT 'New Column', -- New Column
	`CONTENTNO`    INTEGER      NULL     COMMENT '게시글id' -- 게시글id
)
COMMENT 'COMMENTS';

-- COMMENTS
ALTER TABLE `BIT_COMMENTS`
	ADD CONSTRAINT `PK_BIT_COMMENTS` -- COMMENTS Primary key
		PRIMARY KEY (
			`COMMENTNO` -- 댓글id
		);

ALTER TABLE `BIT_COMMENTS`
	MODIFY COLUMN `COMMENTNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글id';

-- 게시글
CREATE TABLE `BIT_CONTENT` (
	`CONTENTNO`      INTEGER      NOT NULL COMMENT '게시글id', -- 게시글id
	`EDITED_DATE`    TIMESTAMP    NULL     COMMENT '수정시간', -- 수정시간
	`MNO`            INTEGER      NOT NULL COMMENT '작성자회원ID', -- 작성자회원ID
	`PARTICIPANTS`   INTEGER      NULL     COMMENT '글답변여부 ex)답변달변 동그라미로 4가지경우생기는거', -- 글답변여부 ex)답변달변 동그라미로 4가지경우생기는거
	`OPENORCLOSE`    CHAR         NULL     COMMENT '게시판글공개여부 ex) 전체공개, 리더, 팔로워', -- 게시판글공개여부 ex) 전체공개, 리더, 팔로워
	`VALIDATION`     BOOLEAN      NULL     COMMENT '게시판리더VALIDATION', -- 게시판리더VALIDATION
	`LOCKER`         BOOLEAN      NULL     COMMENT '게시판LOCKER', -- 게시판LOCKER
	`TITLENO`        INTEGER      NOT NULL COMMENT '부제ID', -- 부제ID
	`OPENTO`         CHAR         NULL     COMMENT '공개설정', -- 공개설정
	`CONTENT_TITLE`  VARCHAR(100) NULL     COMMENT '제목', -- 제목
	`COUNT`          INTEGER      NULL     COMMENT '조회수', -- 조회수
	`EDITED_DATED_F` TIMESTAMP    NULL     COMMENT '팔로워_수정시간', -- 팔로워_수정시간
	`EDITED_DATE_L`  TIMESTAMP    NULL     COMMENT '리더_수정시간', -- 리더_수정시간
	`CONTENT`        VARCHAR(255) NULL     COMMENT '내용', -- 내용
	`GROUPNO`        INTEGER      NOT NULL COMMENT '그룹고유id', -- 그룹고유id
	`GIT_REPOSITORY` VARCHAR(50)  NULL     COMMENT '기트리파지토리', -- 기트리파지토리
	`GIT_ID`         VARCHAR(50)  NULL     COMMENT '기트아이디', -- 기트아이디
	`GIT_PWD`        VARCHAR(50)  NULL     COMMENT '기티비번', -- 기티비번
	`GIT_OAUTHTOKEN` VARCHAR(50)  NULL     COMMENT '기트오쓰토큰' -- 기트오쓰토큰
)
COMMENT '게시글';

-- 게시글
ALTER TABLE `BIT_CONTENT`
	ADD CONSTRAINT `PK_BIT_CONTENT` -- 게시글 기본키
		PRIMARY KEY (
			`CONTENTNO` -- 게시글id
		);

ALTER TABLE `BIT_CONTENT`
	MODIFY COLUMN `CONTENTNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글id';

-- 그룹에 속한 회원
CREATE TABLE `BIT_GROUP_MEMBERS` (
	`GROUP_MEMBERS_MNO` INTEGER NOT NULL COMMENT '그룹멤버고유ID', -- 그룹멤버고유ID
	`GROUPNO`           INTEGER NOT NULL COMMENT '그룹고유id', -- 그룹고유id
	`MNO`               INTEGER NOT NULL COMMENT '회원ID', -- 회원ID
	`ACCEPT`            BOOLEAN NULL     COMMENT '수락' -- 수락
)
COMMENT '그룹에 속한 회원';

-- 그룹에 속한 회원
ALTER TABLE `BIT_GROUP_MEMBERS`
	ADD CONSTRAINT `PK_BIT_GROUP_MEMBERS` -- 그룹에 속한 회원 기본키
		PRIMARY KEY (
			`GROUP_MEMBERS_MNO` -- 그룹멤버고유ID
		);

ALTER TABLE `BIT_GROUP_MEMBERS`
	MODIFY COLUMN `GROUP_MEMBERS_MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '그룹멤버고유ID';

-- ToolTip
CREATE TABLE `TOOLTIP` (
	`TIPNO`        INTEGER      NOT NULL COMMENT 'New Column2', -- New Column2
	`MNO`          INTEGER      NOT NULL COMMENT '회원ID', -- 회원ID
	`TITLE`        VARCHAR(30)  NULL     COMMENT '제목', -- 제목
	`CONTENT`      VARCHAR(255) NULL     COMMENT '컨텐트', -- 컨텐트
	`UPFILE`       VARCHAR(50)  NULL     COMMENT '첨부파일', -- 첨부파일
	`CREATED_DATE` TIMESTAMP    NULL     COMMENT 'New Column', -- New Column
	`UPFILEJ_PATH` VARCHAR(50)  NULL     COMMENT 'New Column3' -- New Column3
)
COMMENT 'ToolTip';

-- ToolTip
ALTER TABLE `TOOLTIP`
	ADD CONSTRAINT `PK_TOOLTIP` -- ToolTip Primary key
		PRIMARY KEY (
			`TIPNO` -- New Column2
		);

ALTER TABLE `TOOLTIP`
	MODIFY COLUMN `TIPNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'New Column2';

-- 게시글 읽음여부
CREATE TABLE `BIT_READORNOT` (
	`CONTENTNO`   INTEGER NOT NULL COMMENT '게시글id', -- 게시글id
	`MNO`         INTEGER NOT NULL COMMENT '회원 ID', -- 회원 ID
	`READ_OR_NOT` BOOLEAN NULL     COMMENT '읽음여부' -- 읽음여부
)
COMMENT '게시글 읽음여부';

-- MESSAGE
CREATE TABLE `BIT_MESSAGE` (
	`MESSAGENO`  INTEGER      NOT NULL COMMENT '메시지식별', -- 메시지식별
	`SENDERNO`   INTEGER      NULL     COMMENT '전달자아이디', -- 전달자아이디
	`CONTENT`    VARCHAR(255) NULL     COMMENT '메시지 내용', -- 메시지 내용
	`DATE`       TIMESTAMP    NULL     COMMENT '등록 날짜', -- 등록 날짜
	`MNO`        INTEGER      NULL     COMMENT '회원ID', -- 회원ID
	`GROUPNO`    INTEGER      NULL     COMMENT '그룹고유id', -- 그룹고유id
	`INVITATION` BOOLEAN      NULL     COMMENT 'New Column' -- New Column
)
COMMENT 'MESSAGE';

-- MESSAGE
ALTER TABLE `BIT_MESSAGE`
	ADD CONSTRAINT `PK_BIT_MESSAGE` -- MESSAGE Primary key
		PRIMARY KEY (
			`MESSAGENO` -- 메시지식별
		);

ALTER TABLE `BIT_MESSAGE`
	MODIFY COLUMN `MESSAGENO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '메시지식별';

-- FILES
CREATE TABLE `BIT_FILES` (
	`BIT_FILENO`   INTEGER      NOT NULL COMMENT 'New Column4', -- New Column4
	`FILENAME`     VARCHAR(255) NULL     COMMENT 'FileName', -- FileName
	`GIT_REP`      VARCHAR(255) NULL     COMMENT 'New Column', -- New Column
	`GIT_SHA`      VARCHAR(100) NULL     COMMENT 'New Column2', -- New Column2
	`GIT_FILEPATH` VARCHAR(100) NULL     COMMENT 'New Column3', -- New Column3
	`FILENO`       INTEGER      NULL     COMMENT 'New Column5' -- New Column5
)
COMMENT 'FILES';

-- FILES
ALTER TABLE `BIT_FILES`
	ADD CONSTRAINT `PK_BIT_FILES` -- FILES Primary key
		PRIMARY KEY (
			`BIT_FILENO` -- New Column4
		);

ALTER TABLE `BIT_FILES`
	MODIFY COLUMN `BIT_FILENO` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'New Column4';

-- 공지
CREATE TABLE `BIT_ANNOUNCE` (
	`ANNOUNCENO` INTEGER   NOT NULL COMMENT '공지고유ID', -- 공지고유ID
	`BEGIN`      TIMESTAMP NULL     COMMENT '시작시간', -- 시작시간
	`END`        TIMESTAMP NULL     COMMENT '종료시간', -- 종료시간
	`LEADNO`     INTEGER   NOT NULL COMMENT '리더고유ID' -- 리더고유ID
)
COMMENT '공지';

-- 공지
ALTER TABLE `BIT_ANNOUNCE`
	ADD CONSTRAINT `PK_BIT_ANNOUNCE` -- 공지 기본키
		PRIMARY KEY (
			`ANNOUNCENO` -- 공지고유ID
		);

ALTER TABLE `BIT_ANNOUNCE`
	MODIFY COLUMN `ANNOUNCENO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지고유ID';

-- 데이터
CREATE TABLE `BIT_DATA` (
	`DNO`         INTEGER      NOT NULL COMMENT 'DATA고유ID', -- DATA고유ID
	`UPDATA`      VARCHAR(255) NOT NULL COMMENT '업로드데이터', -- 업로드데이터
	`LEADNO`      INTEGER      NOT NULL COMMENT '리더고유ID', -- 리더고유ID
	`UPDATA_PATH` VARCHAR(50)  NOT NULL COMMENT '업로드경로' -- 업로드경로
)
COMMENT '데이터';

-- 데이터
ALTER TABLE `BIT_DATA`
	ADD CONSTRAINT `PK_BIT_DATA` -- 데이터 기본키
		PRIMARY KEY (
			`DNO` -- DATA고유ID
		);

ALTER TABLE `BIT_DATA`
	MODIFY COLUMN `DNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'DATA고유ID';

-- 리더
CREATE TABLE `BIT_LEADER_WRITE` (
	`LEADNO`       INTEGER      NOT NULL COMMENT '리더고유ID', -- 리더고유ID
	`TITLE`        VARCHAR(30)  NOT NULL COMMENT '제목', -- 제목
	`CONTENT`      VARCHAR(255) NULL     COMMENT '내용', -- 내용
	`WRITER`       VARCHAR(30)  NOT NULL COMMENT '글쓴이', -- 글쓴이
	`GROUPNO`      INTEGER      NOT NULL COMMENT '그룹고유id', -- 그룹고유id
	`TYPE`         BOOLEAN      NOT NULL COMMENT '타입', -- 타입
	`CREATED_DATE` TIMESTAMP    NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '리더';

-- 리더
ALTER TABLE `BIT_LEADER_WRITE`
	ADD CONSTRAINT `PK_BIT_LEADER_WRITE` -- 리더 기본키
		PRIMARY KEY (
			`LEADNO` -- 리더고유ID
		);

ALTER TABLE `BIT_LEADER_WRITE`
	MODIFY COLUMN `LEADNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '리더고유ID';

-- 초대
CREATE TABLE `INVITATION` (
	`NO`        INTEGER NOT NULL COMMENT '초대id', -- 초대id
	`GROUPNO`   INTEGER NULL     COMMENT '그룹고유id', -- 그룹고유id
	`MESSAGENO` INTEGER NULL     COMMENT '메시지식별', -- 메시지식별
	`TYPE`      BOOLEAN NULL     COMMENT '타입', -- 타입
	`MNO`       INTEGER NULL     COMMENT '회원ID' -- 회원ID
)
COMMENT '초대';

-- 초대
ALTER TABLE `INVITATION`
	ADD CONSTRAINT `PK_INVITATION` -- 초대 기본키
		PRIMARY KEY (
			`NO` -- 초대id
		);

ALTER TABLE `INVITATION`
	MODIFY COLUMN `NO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '초대id';

-- New Table5
CREATE TABLE `BIT_FILE_FOLDER` (
	`FILENO`    INTEGER NOT NULL COMMENT 'New Column', -- New Column
	`CONTENTNO` INTEGER NULL     COMMENT '게시글id', -- 게시글id
	`FILEORDER` INTEGER NULL     COMMENT 'New Column2' -- New Column2
)
COMMENT 'New Table5';

-- New Table5
ALTER TABLE `BIT_FILE_FOLDER`
	ADD CONSTRAINT `PK_BIT_FILE_FOLDER` -- New Table5 Primary key
		PRIMARY KEY (
			`FILENO` -- New Column
		);

ALTER TABLE `BIT_FILE_FOLDER`
	MODIFY COLUMN `FILENO` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'New Column';

-- 게시글 위키 답변
CREATE TABLE ` BIT_CONTENT_COLLABORATORS` (
	`WRITERNO`         INTEGER      NOT NULL COMMENT '글쓴이번호', -- 글쓴이번호
	`CONTENTNO`        INTEGER      NOT NULL COMMENT 'ID', -- ID
	`LEADER`           INTEGER      NULL     COMMENT '리더글쓴이들', -- 리더글쓴이들
	`FOLLOWER`         INTEGER      NULL     COMMENT '팔로워글쓴이들', -- 팔로워글쓴이들
	`CONTENT_LEADER`   VARCHAR(255) NULL     COMMENT '리더가 쓴 내용', -- 리더가 쓴 내용
	`CONTENT_FOLLOWER` VARCHAR(255) NULL     COMMENT '팔로워가 쓴 내용' -- 팔로워가 쓴 내용
)
COMMENT '게시글 위키 답변';

-- 게시글 위키 답변
ALTER TABLE ` BIT_CONTENT_COLLABORATORS`
	ADD CONSTRAINT `PK_ BIT_CONTENT_COLLABORATORS` -- 게시글 위키 답변 기본키
		PRIMARY KEY (
			`WRITERNO` -- 글쓴이번호
		);

-- 새 테이블2
CREATE TABLE `BIT_GROUP_REPOSITORY` (
	`GROUP_REPOSITORY_NO` INTEGER     NOT NULL COMMENT '그룹리파지토리.고유ID', -- 그룹리파지토리.고유ID
	`GIT_REPOSITORY`      VARCHAR(50) NOT NULL COMMENT '기트리파지토리', -- 기트리파지토리
	`GIT_ID`              VARCHAR(50) NULL     COMMENT '기트아이디', -- 기트아이디
	`GIT_PWD`             VARCHAR(50) NULL     COMMENT '기트암호', -- 기트암호
	`GIT_OAUTH_TOKEN`     VARCHAR(50) NULL     COMMENT '기트인증토큰', -- 기트인증토큰
	`GROUPNO`             INTEGER     NOT NULL COMMENT '그룹고유ID' -- 그룹고유ID
)
COMMENT '새 테이블2';

-- 새 테이블2
ALTER TABLE `BIT_GROUP_REPOSITORY`
	ADD CONSTRAINT `PK_BIT_GROUP_REPOSITORY` -- 새 테이블2 기본키
		PRIMARY KEY (
			`GROUP_REPOSITORY_NO` -- 그룹리파지토리.고유ID
		);

-- 부제
ALTER TABLE `BIT_TITLE`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_TITLE` -- 그룹 -> 부제
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유id
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);

-- COMMENTS
ALTER TABLE `BIT_COMMENTS`
	ADD CONSTRAINT `FK_BIT_CONTENT_TO_BIT_COMMENTS` -- 게시글 -> COMMENTS
		FOREIGN KEY (
			`CONTENTNO` -- 게시글id
		)
		REFERENCES `BIT_CONTENT` ( -- 게시글
			`CONTENTNO` -- 게시글id
		);

-- 게시글
ALTER TABLE `BIT_CONTENT`
	ADD CONSTRAINT `FK_BIT_TITLE_TO_BIT_CONTENT` -- 부제 -> 게시글
		FOREIGN KEY (
			`TITLENO` -- 부제ID
		)
		REFERENCES `BIT_TITLE` ( -- 부제
			`TITLENO` -- 부제ID
		);

-- 게시글
ALTER TABLE `BIT_CONTENT`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_CONTENT` -- 그룹 -> 게시글
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유id
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);

-- 그룹에 속한 회원
ALTER TABLE `BIT_GROUP_MEMBERS`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_GROUP_MEMBERS` -- 그룹 -> 그룹에 속한 회원
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유id
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);

-- 그룹에 속한 회원
ALTER TABLE `BIT_GROUP_MEMBERS`
	ADD CONSTRAINT `FK_BIT_MEMBERS_TO_BIT_GROUP_MEMBERS` -- 회원 -> 그룹에 속한 회원
		FOREIGN KEY (
			`MNO` -- 회원ID
		)
		REFERENCES `BIT_MEMBERS` ( -- 회원
			`MNO` -- 회원ID
		);

-- ToolTip
ALTER TABLE `TOOLTIP`
	ADD CONSTRAINT `FK_BIT_MEMBERS_TO_TOOLTIP` -- 회원 -> ToolTip
		FOREIGN KEY (
			`MNO` -- 회원ID
		)
		REFERENCES `BIT_MEMBERS` ( -- 회원
			`MNO` -- 회원ID
		);

-- 게시글 읽음여부
ALTER TABLE `BIT_READORNOT`
	ADD CONSTRAINT `FK_BIT_CONTENT_TO_BIT_READORNOT` -- 게시글 -> 게시글 읽음여부
		FOREIGN KEY (
			`CONTENTNO` -- 게시글id
		)
		REFERENCES `BIT_CONTENT` ( -- 게시글
			`CONTENTNO` -- 게시글id
		);

-- MESSAGE
ALTER TABLE `BIT_MESSAGE`
	ADD CONSTRAINT `FK_BIT_MEMBERS_TO_BIT_MESSAGE` -- 회원 -> MESSAGE
		FOREIGN KEY (
			`MNO` -- 회원ID
		)
		REFERENCES `BIT_MEMBERS` ( -- 회원
			`MNO` -- 회원ID
		);

-- MESSAGE
ALTER TABLE `BIT_MESSAGE`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_MESSAGE` -- 그룹 -> MESSAGE
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유id
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);

-- FILES
ALTER TABLE `BIT_FILES`
	ADD CONSTRAINT `FK_BIT_FILE_FOLDER_TO_BIT_FILES` -- New Table5 -> FILES
		FOREIGN KEY (
			`FILENO` -- New Column5
		)
		REFERENCES `BIT_FILE_FOLDER` ( -- New Table5
			`FILENO` -- New Column
		);

-- 공지
ALTER TABLE `BIT_ANNOUNCE`
	ADD CONSTRAINT `FK_BIT_LEADER_WRITE_TO_BIT_ANNOUNCE` -- 리더 -> 공지
		FOREIGN KEY (
			`LEADNO` -- 리더고유ID
		)
		REFERENCES `BIT_LEADER_WRITE` ( -- 리더
			`LEADNO` -- 리더고유ID
		);

-- 데이터
ALTER TABLE `BIT_DATA`
	ADD CONSTRAINT `FK_BIT_LEADER_WRITE_TO_BIT_DATA` -- 리더 -> 데이터
		FOREIGN KEY (
			`LEADNO` -- 리더고유ID
		)
		REFERENCES `BIT_LEADER_WRITE` ( -- 리더
			`LEADNO` -- 리더고유ID
		);

-- 리더
ALTER TABLE `BIT_LEADER_WRITE`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_LEADER_WRITE` -- 그룹 -> 리더
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유id
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);

-- 초대
ALTER TABLE `INVITATION`
	ADD CONSTRAINT `FK_BIT_MESSAGE_TO_INVITATION` -- MESSAGE -> 초대
		FOREIGN KEY (
			`MESSAGENO` -- 메시지식별
		)
		REFERENCES `BIT_MESSAGE` ( -- MESSAGE
			`MESSAGENO` -- 메시지식별
		);

-- 초대
ALTER TABLE `INVITATION`
	ADD CONSTRAINT `FK_BIT_MEMBERS_TO_INVITATION` -- 회원 -> 초대
		FOREIGN KEY (
			`MNO` -- 회원ID
		)
		REFERENCES `BIT_MEMBERS` ( -- 회원
			`MNO` -- 회원ID
		);

-- New Table5
ALTER TABLE `BIT_FILE_FOLDER`
	ADD CONSTRAINT `FK_BIT_CONTENT_TO_BIT_FILE_FOLDER` -- 게시글 -> New Table5
		FOREIGN KEY (
			`CONTENTNO` -- 게시글id
		)
		REFERENCES `BIT_CONTENT` ( -- 게시글
			`CONTENTNO` -- 게시글id
		);

-- 게시글 위키 답변
ALTER TABLE ` BIT_CONTENT_COLLABORATORS`
	ADD CONSTRAINT `FK_BIT_CONTENT_TO_ BIT_CONTENT_COLLABORATORS` -- 게시글 -> 게시글 위키 답변
		FOREIGN KEY (
			`CONTENTNO` -- ID
		)
		REFERENCES `BIT_CONTENT` ( -- 게시글
			`CONTENTNO` -- 게시글id
		);

-- 새 테이블2
ALTER TABLE `BIT_GROUP_REPOSITORY`
	ADD CONSTRAINT `FK_BIT_GROUP_TO_BIT_GROUP_REPOSITORY` -- 그룹 -> 새 테이블2
		FOREIGN KEY (
			`GROUPNO` -- 그룹고유ID
		)
		REFERENCES `BIT_GROUP` ( -- 그룹
			`GROUPNO` -- 그룹고유id
		);