<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="blooddonation.service.DashboardService" %>
<%@ page import="blooddonation.dao.impl.DonneurDaoImpl" %>
<%@ page import="blooddonation.bean.Donneur" %>
<%
        DonneurDaoImpl donorDao = new DonneurDaoImpl();
        DashboardService dashboardService = new DashboardService(donorDao, null, null, null); // juste pour donneurs
        java.util.List<Donneur> donors = donorDao.getAllDonors();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestion des donneurs</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp" />

    <!-- Main -->
    <div class="main">
        <!-- Navbar -->
        <jsp:include page="navbar.jsp" />

        <!-- Content -->
        <main class="content">
            <div class="container-fluid p-0">
                <h1 class="h3 mb-3"><strong>Gestion</strong> - Donneurs</h1>

                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Liste des donneurs</h5>
                    </div>
                    <div class="card-body">
                        <a href="add-donor.jsp" class="btn btn-primary mb-3">Ajouter un donneur</a>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Email</th>
                                <th>Téléphone</th>
                                <th>Groupe Sanguin</th>
                                <th>Disponibilité</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for(Donneur d : donors) { %>
                            <tr>
                                <td><%= d.getId() %></td>
                                <td><%= d.getNom() %></td>
                                <td><%= d.getPrenom() %></td>
                                <td><%= d.getEmail() %></td>
                                <td><%= d.getPhoneNum() %></td>
                                <td><%= d.getGroupeSanguin() %></td>
                                <td>
                                    <% if(d.isDisponibilite()) { %>
                                    <span class="badge bg-success">Disponible</span>
                                    <% } else { %>
                                    <span class="badge bg-danger">Non disponible</span>
                                    <% } %>
                                </td>
                                <td>
                                    <a href="edit-donor.jsp?id=<%= d.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                                    <a href="delete-donor?id=<%= d.getId() %>" class="btn btn-sm btn-danger">Supprimer</a>
                                </td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>

        <!-- Footer -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="text-center text-muted">
                    © 2025 MedConnect - Banque de Sang Nationale
                </div>
            </div>
        </footer>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>feather.replace()</script>
</body>
</html>
