-- 게시판
DROP TABLE IF EXISTS proj_board.tbl_board RESTRICT;

-- 게시판
DROP SCHEMA IF EXISTS proj_board;

-- 게시판
CREATE SCHEMA proj_board;

-- 게시판
CREATE TABLE proj_board.tbl_board (
	bno        INT           NOT NULL COMMENT 'bno', -- bno
	title      VARCHAR(200)  NOT NULL COMMENT 'title', -- title
	content    VARCHAR(2000) NOT NULL COMMENT 'content', -- content
	writer     VARCHAR(50)   NOT NULL COMMENT 'writer', -- writer
	regdate    DATETIME      NULL  default  current_timestamp  COMMENT 'regdate', -- regdate
	updatedate DATETIME      NULL default current_timestamp    COMMENT 'updatedate' -- updatedate
)
COMMENT '게시판';

-- 게시판
ALTER TABLE proj_board.tbl_board
	ADD CONSTRAINT PK_tbl_board -- 게시판 기본키
		PRIMARY KEY (
			bno -- bno
		);
