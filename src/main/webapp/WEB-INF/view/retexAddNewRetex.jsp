<%@ include file="header.jspf"%>
<link rel="stylesheet" href="/resources/css/addRetexForm.css">
<security:csrfMetaTags/>
<br>
<button class="btn btn-dark" onclick="window.location.href = '/retex';">Inapoi la Retex</button>
<h1 style="color:black;text-align:left;"> Adauga o noua inregistrare</h1>
<hr>
<%--<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
   <script> tinymce.init({selector:'textarea'});</script>--%>
<%--
   <script src="//cdn.ckeditor.com/4.13.1/full-all/ckeditor.js"></script>

   <body>

   <textarea name="editor1"><button>Save</button></textarea>
                   <script>
                           CKEDITOR.replace( 'editor1' );
                   </script>
   --%>
<form:form action="saveNewRetex" modelAttribute="recordSolution" method="POST" accept-charset = "utf-8">
   <div class="separatecontainer">
      <div class = "row">
         <div class="col-25">
            <label class="label1">Titlu:</label>
         </div>
         <div class = "col-75">
            <form:input path="record.titlu"/>
         </div>
      </div>
      <div class = "row">
         <div class="col-25">
            <label class="label1">Categorie:</label>
         </div>
         <div class = "col-75">
            <form:input path="record.categorie"/>
         </div>
      </div>
      <div class="row">
         <div class="col-25">
            <label class="label1">Descriere:</label>
         </div>
         <div class="col-75">
            <textarea id="summernote" maxlength="10000" name="record.descriere" style="height:200px"></textarea>
            <script>
               $('#summernote').summernote({
                 placeholder: 'Adauga descriere',
                 tabsize: 2,
                 height: 200,
                 toolbar: [
                   ['style', ['style']],
                   ['font', ['bold', 'underline', 'clear']],
                   ['color', ['color']],
                   ['para', ['ul', 'ol', 'paragraph']],
                   ['table', ['table']],
                   ['insert', ['link', 'picture', 'video']],
                   ['view', ['fullscreen', 'codeview', 'help']]
                 ]
               });
            </script>
         </div>
      </div>
      <div class="row">
         <div class="col-25">
            <label class="label1">Solutie:</label>
         </div>
         <div class="col-75">
            <textarea  id="summernoteSol" name="solution.solutie"></textarea>
            <script>
               $('#summernoteSol').summernote({
                 placeholder: 'Adauga solutie',
                 tabsize: 1,
                 height: 200,
                 toolbar: [
                   ['style', ['style']],
                   ['font', ['bold', 'underline', 'clear']],
                   ['color', ['color']],
                   ['para', ['ul', 'ol', 'paragraph']],
                   ['table', ['table']],
                   ['insert', ['link', 'picture', 'video']],
                   ['view', ['fullscreen', 'codeview', 'help']]
                 ]
               });
            </script>
         </div>
      </div>
   </div>
   <hr>
   <input type="submit" value="Adauga" class="btn btn-outline-primary"/>
   <button type="button" class="btn btn-outline-danger" onclick="closeAddRetex()">Inchide</button>
</form:form>
</body>
<%@ include file="footer.jspf"%>
<script>
   function closeAddRetex() {
       window.location.href = '/retex';
   }

   $(document).ready(function() {
     var len = 0;
     var maxchar = 10000;

     $( '#summernote' ).keyup(function(){
       len = this.value.length
       if(len > maxchar){
           return false;
       }
       else {
           $( "#remainingC" ).html(( maxchar - len ) +"/10000 " );
       }
     })
   });

   $(document).ready(function() {
     var len = 0;
     var maxchar = 20000;

     $( '#summernote' ).keyup(function(){
       len = this.value.length
       if(len > maxchar){
           return false;
       }
       else {
           $( "#remainingD" ).html( ( maxchar - len ) +"/20000 " );
       }
     })
   });


</script>
