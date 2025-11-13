<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="blooddonation.bean.Demande" %>
<%@ page import="blooddonation.bean.Hopital" %>

<%
    Hopital hopital = (Hopital) session.getAttribute("user");
    List<Demande> recentDemandes = (List<Demande>) request.getAttribute("recentDemandes");
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Hôpital - MedConnect</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="dashboard.jsp">Espace Hôpital</a>
            <ul class="sidebar-nav">
                <li class="sidebar-item active"><a class="sidebar-link" href="dashboard.jsp">Tableau de bord</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="demandes.jsp">Mes demandes</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="profil.jsp">Profil</a></li>
                <li class="sidebar-item"><a class="sidebar-link text-danger" href="../logout.jsp">Déconnexion</a></li>
            </ul>
        </div>
    </nav>

    <div class="main">
        <main class="content">
            <div class="container-fluid p-0">
                <h1 class="h3 mb-3">Bienvenue, <%= hopital.getNom() %></h1>

                <div class="row">
                    <div class="col-md-4">
                        <div class="card"><div class="card-body"><h5>Total des demandes</h5><h1><%= request.getAttribute("totalDemandes") %></h1></div></div>
                    </div>
                    <div class="col-md-4">
                        <div class="card"><div class="card-body"><h5>Demandes actives</h5><h1><%= request.getAttribute("activeDemandes") %></h1></div></div>
                    </div>
                    <div class="col-md-4">
                        <div class="card"><div class="card-body"><h5>Ville</h5><h1><%= hopital.getVille() %></h1></div></div>
                    </div>
                </div>

                <div class="card mt-4">
                    <div class="card-header">Dernières demandes publiées</div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead><tr><th>ID</th><th>Groupe</th><th>Date</th><th>Statut</th></tr></thead>
                            <tbody>
                            <% if (recentDemandes != null && !recentDemandes.isEmpty()) {
                                for (Demande d : recentDemandes) { %>
                            <tr>
                                <td><%= d.getIdDemande() %></td>
                                <td><%= d.getGroupeSanguin() %></td>
                                <td><%= d.getDateDemande() %></td>
                                <td><span class="badge bg-danger"><%= d.getStatut() %></span></td>
                            </tr>
                            <%  } } else { %>
                            <tr><td colspan="4" class="text-center text-muted">Aucune demande enregistrée.</td></tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>