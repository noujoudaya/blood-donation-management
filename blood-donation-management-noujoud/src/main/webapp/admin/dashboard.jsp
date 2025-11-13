<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="blooddonation.service.DashboardService" %>
<%@ page import="blooddonation.dao.impl.*" %>
<%@ page import="blooddonation.bean.*" %>

<%
    // DAOs
    DonneurDaoImpl donorDao = new DonneurDaoImpl();
    HopitalDaoImpl hospitalDao = new HopitalDaoImpl();
    DonDaoImpl donationDao = new DonDaoImpl();
    DemandeDaoImpl announcementDao = new DemandeDaoImpl();

    // Dashboard Service
    DashboardService dashboardService = new DashboardService(donorDao, hospitalDao, donationDao, announcementDao);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - MedConnect</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="dashboard.jsp">MedConnect Admin</a>
            <ul class="sidebar-nav">
                <li class="sidebar-item active"><a class="sidebar-link" href="dashboard.jsp">Tableau de bord</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="manage-donors.jsp">Gestion des donneurs</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="manage-hospitals.jsp">Gestion des hôpitaux</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="manage-announcements.jsp">Annonces urgentes</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="reports.jsp">Rapports et statistiques</a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="settings.jsp">Paramètres</a></li>
                <li class="sidebar-item"><a class="sidebar-link text-danger" href="logout.jsp">Déconnexion</a></li>
            </ul>
        </div>
    </nav>

    <!-- Main -->
    <div class="main">
        <!-- Navbar -->
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle"><i class="hamburger align-self-center"></i></a>
            <ul class="navbar-nav navbar-align">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <img src="img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Admin" />
                        Admin Banque de Sang
                    </a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a class="dropdown-item" href="profile.jsp">Profil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-danger" href="../logout.jsp">Déconnexion</a>
                    </div>
                </li>
            </ul>
        </nav>

        <!-- Content -->
        <main class="content">
            <div class="container-fluid p-0">
                <h1 class="h3 mb-3">Tableau de bord - Espace Administrateur</h1>

                <!-- Statistics -->
                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Donneurs inscrits</h5>
                                <h1 class="mb-3"><%= dashboardService.getTotalDonors() %></h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Hôpitaux partenaires</h5>
                                <h1 class="mb-3"><%= dashboardService.getTotalHospitals() %></h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Dons effectués</h5>
                                <h1 class="mb-3"><%= dashboardService.getTotalDonationsThisMonth() %></h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Annonces actives</h5>
                                <h1 class="mb-3"><%= dashboardService.getActiveUrgentDemands() %></h1>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Blood Stock -->
                <%--<div class="row mt-4">
                    <div class="col-md-8">
                        <div class="card flex-fill">
                            <div class="card-header">Stock sanguin par groupe</div>
                            <div class="card-body">
                                <table class="table table-borderless">
                                    <tbody>
                                    <% String[] groups = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}; %>
                                    <% for(String g : groups) { %>
                                    <tr>
                                        <td><%= g %></td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-danger" role="progressbar"
                                                     style="width: <%= dashboardService.getBloodStockPercentage(g) %>%"
                                                     aria-valuenow="<%= dashboardService.getBloodStock(g) %>"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <%= dashboardService.getBloodStock(g) %> unités
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <!-- Donor Distribution -->
                    <div class="col-md-4">
                        <div class="card flex-fill">
                            <div class="card-header">Répartition géographique des donneurs</div>
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead><tr><th>Ville</th><th>Nombre</th></tr></thead>
                                    <tbody>
                                    <% String[] cities = {"Rabat", "Casablanca", "Fès", "Marrakech"}; %>
                                    <% for(String city : cities) { %>
                                    <tr>
                                        <td><%= city %></td>
                                        <td><%= dashboardService.getDonorsByCity(city) %></td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>--%>

                <!-- Urgent Announcements -->
                <div class="card mt-4">
                    <div class="card-header">Annonces urgentes récentes</div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr><th>ID</th><th>Groupe</th><th>Hôpital</th><th>Ville</th><th>Date</th><th>Statut</th></tr>
                            </thead>
                            <tbody>
                            <% for(Demande a : dashboardService.getRecentDemands()) { %>
                            <tr>
                                <td><%= a.getIdDemande() %></td>
                                <td><%= a.getGroupeSanguin() %></td>
                                <td><%= a.getHopital().getNom() %></td>
                                <td><%= a.getHopital().getVille() %></td>
                                <td><%= a.getDateDemande() %></td>
                                <td>
                                    <% if("Urgent".equals(a.getStatut()) || "Critique".equals(a.getStatut())) { %>
                                    <span class="badge bg-danger">Urgente</span>
                                    <% } else { %>
                                    <span class="badge bg-warning">En cours</span>
                                    <% } %>
                                </td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                        <a href="manage-announcements.jsp" class="btn btn-sm btn-primary">Voir toutes les annonces</a>
                    </div>
                </div>

                <!-- Latest Donations -->
                <div class="card mt-4">
                    <div class="card-header">Derniers dons enregistrés</div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead><tr><th>Donneur</th><th>Hôpital</th><th>Groupe</th><th>Date</th></tr></thead>
                            <tbody>
                            <% for(Don d : dashboardService.getRecentDonations()) { %>
                            <tr>
                                <td><%= d.getDonneur().getNom() %> <%= d.getDonneur().getPrenom() %></td>
                                <td><%= d.getDemande().getHopital().getNom() %></td>
                                <td><%= d.getDemande().getGroupeSanguin() %></td>
                                <td><%= d.getDateDon() %></td>
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
            <div class="container-fluid text-center text-muted">
                © 2025 MedConnect - Banque de Sang Nationale
            </div>
        </footer>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>feather.replace()</script>
</body>
</html>
