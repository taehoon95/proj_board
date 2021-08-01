show tables;

select * from tbl_board;

SELECT MAX(bno)+1 FROM tbl_board;

select * from tbl_board where bno > 0;

/* 이미 정렬하는 과정을 생략 하였기 떄문에 SORT하는 과정을 생략할 수 있다. */
SELECT /*+index_desc (tbl_board pk_board) */* from tbl_board;

/*@rownum 초기화*/
set @rownum:=0;

select @ROWNUM rn, bno, title from tbl_board;


SELECT /*+index_desc (tbl_board) */
@rownum :=@rownum+1 rn , bno, title, content 
  from tbl_board
 where (@rownum:= 0) <= 20;

/*alias를 붙여주지 않으면 
 * Every derived table must have its own alias 오류가 난다.*/
<![DATA[
	select bno,title,content,writer,regdate,updatedate
  	  from (
  		SELECT /*+index_desc (tbl_board) */
			@rownum :=@rownum+1 rn ,bno,title,content,writer,regdate,updatedate
  		  from tbl_board
		 where (@rownum:= 0) <= 20
  		) c
 	where rn > 10; 
]]>

select bno,title,content,writer,regdate,updatedate 
  from ( 
        SELECT  
               @rownum :=@rownum+1 rn ,bno,title,content,writer,regdate,updatedate 
          from tbl_board 
         where (@rownum:= 0) <= 20 
         order by rn desc 
       ) c 
where rn > 10;

select bno,title,content,writer,regdate,updatedate from ( SELECT @rownum :=@rownum+1 rn ,bno,title,content,writer,regdate,updatedate from tbl_board where (@rownum:= 0) <= 2 * 10 order by rn desc ) c where rn > (2 - 1) * 10