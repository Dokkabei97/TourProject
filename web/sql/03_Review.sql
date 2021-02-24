ALTER TABLE REVIEW
	DROP
		CONSTRAINT FK_TRAVEL_TO_REVIEW
		CASCADE;

ALTER TABLE REVIEW
	DROP
		CONSTRAINT FK_MEMBER_TO_REVIEW
		CASCADE;

ALTER TABLE REVIEW
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_REVIEW;

/* 리뷰 */
DROP TABLE REVIEW
	CASCADE CONSTRAINTS;

/* 리뷰 */
CREATE TABLE REVIEW (
	RNUM NUMBER(8) NOT NULL, /* 리뷰번호 */
	RSTAR NUMBER(2) NOT NULL, /* 별점 */
	RRECOMMEND NUMBER(8), /* 추천 */
	RFILE1 VARCHAR2(200), /* 첨부파일1 */
	RFILE2 VARCHAR2(200), /* 첨부파일2 */
	RFILE3 VARCHAR2(200), /* 첨부파일3 */
	RCONTENT VARCHAR2(300) NOT NULL, /* 내용 */
	TNUM NUMBER(8) NOT NULL, /* 여행지번호 */
	IDX NUMBER(8) NOT NULL /* 회원번호 */
);

COMMENT ON TABLE REVIEW IS '리뷰';

COMMENT ON COLUMN REVIEW.RNUM IS '리뷰번호';

COMMENT ON COLUMN REVIEW.RSTAR IS '별점';

COMMENT ON COLUMN REVIEW.RRECOMMEND IS '추천';

COMMENT ON COLUMN REVIEW.RFILE1 IS '첨부파일1';

COMMENT ON COLUMN REVIEW.RFILE2 IS '첨부파일2';

COMMENT ON COLUMN REVIEW.RFILE3 IS '첨부파일3';

COMMENT ON COLUMN REVIEW.RCONTENT IS '내용';

COMMENT ON COLUMN REVIEW.TNUM IS '여행지번호';

COMMENT ON COLUMN REVIEW.IDX IS '회원번호';

CREATE UNIQUE INDEX PK_REVIEW
	ON REVIEW (
		RNUM ASC
	);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT PK_REVIEW
		PRIMARY KEY (
			RNUM
		);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT FK_TRAVEL_TO_REVIEW
		FOREIGN KEY (
			TNUM
		)
		REFERENCES TRAVEL (
			TNUM
		);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT FK_MEMBER_TO_REVIEW
		FOREIGN KEY (
			IDX
		)
		REFERENCES MEMBER (
			IDX
		);