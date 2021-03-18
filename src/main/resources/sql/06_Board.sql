ALTER TABLE BOARD
	DROP
		CONSTRAINT FK_MEMBER_TO_BOARD
		CASCADE;

ALTER TABLE BOARD
	DROP
		CONSTRAINT FK_BOARD_CATEGORY_TO_BOARD
		CASCADE;

ALTER TABLE BOARD
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_BOARD;

/* 게시판 */
DROP TABLE BOARD
	CASCADE CONSTRAINTS;

/* 게시판 */
CREATE TABLE BOARD (
	BNUM NUMBER(10) NOT NULL, /* 게시판번호 */
	BTITLE VARCHAR2(20) NOT NULL, /* 글제목 */
	BCONTENT VARCHAR2(300) NOT NULL, /* 글내용 */
	BINQUIRY NUMBER(8), /* 조회 */
	BDATE DATE, /* 작성일 */
	BUPLOAD1 VARCHAR2(20), /* 업로드 */
	BUPLOAD2 VARCHAR2(20), /* 업로드2 */
	BUPLOAD3 VARCHAR2(20), /* 업로드3 */
	BRECOMMEND NUMBER(8), /* 추천 */
	IDX NUMBER(8), /* 회원번호 */
	CG_NUM NUMBER(3) NOT NULL /* 게시판카테고리번호 */
);

COMMENT ON TABLE BOARD IS '게시판';

COMMENT ON COLUMN BOARD.BNUM IS '게시판번호';

COMMENT ON COLUMN BOARD.BTITLE IS '글제목';

COMMENT ON COLUMN BOARD.BCONTENT IS '글내용';

COMMENT ON COLUMN BOARD.BINQUIRY IS '조회';

COMMENT ON COLUMN BOARD.BDATE IS '작성일';

COMMENT ON COLUMN BOARD.BUPLOAD1 IS '업로드1';

COMMENT ON COLUMN BOARD.BUPLOAD2 IS '업로드2';

COMMENT ON COLUMN BOARD.BUPLOAD3 IS '업로드3';

COMMENT ON COLUMN BOARD.BRECOMMEND IS '추천';

COMMENT ON COLUMN BOARD.IDX IS '회원번호';

COMMENT ON COLUMN BOARD.CG_NUM IS '게시판카테고리번호';

CREATE UNIQUE INDEX PK_BOARD
	ON BOARD (
		BNUM ASC
	);

ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD
		PRIMARY KEY (
			BNUM
		);

ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_MEMBER_TO_BOARD
		FOREIGN KEY (
			IDX
		)
		REFERENCES MEMBER (
			IDX
		);

ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_BOARD_CATEGORY_TO_BOARD
		FOREIGN KEY (
			CG_NUM
		)
		REFERENCES BOARD_CATEGORY (
			CG_NUM
		);

DROP SEQUENCE  BOARD_SEQ;

CREATE SEQUENCE BOARD_SEQ NOCACHE; -- 시퀸스