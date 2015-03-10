<jsp:include page="header.jsp" />

<script type="text/javascript">

    function ListCommentaires(comments) {
        this.liste = comments;
        this.toString = function () {
            var html = "";
            html += '<div class="commentaires">';
            for (commentaire of this.liste){
                html += '<div class="commentaire">';
                html += 'Par ' + commentaire.utilisateur.usertag;
                html += ', le ' + new Date(commentaire.date_commentaire);
                html += '<br/>' + commentaire.commentaire;
                html += '</div>';
            }
            html += '</div>';
            return html;
        };
    }
    function Book(titre, auteur, commentaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.listCommentaires = new ListCommentaires(commentaires);
        this.toString = function () {
            var string = "<div>";
            string += "Auteur : " + this.auteur + "<br/>";
            string += "Titre : " + this.titre;
            string += "</div>";
            string += this.listCommentaires.toString();
            return string;
        };
    }

    function getbook() {
        var id_book = $('#id_livre').val();
        console.log(id_book);
        $.ajax({
            url: '${pageContext.request.contextPath}/welcome/book.do',
            data: {id: id_book},
            success: function (data) {
                var book = new Book(data.titre, data.auteur, data.commentaires);
                $('#resultat').html(book.toString());
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus + "," + errorThrown + "," + jqXHR.responseText); //error logging
            }

        });
    }
</script>   
<label>id du livre<input type="text" id="id_livre"/></label>
<input type="button" onclick="javascript:getbook();" value="go"/>

<p>livre trouve :</p>
<div id="resultat">

</div>
</body>
</html>
