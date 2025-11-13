<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="blooddonation.bean.Don" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Historique de mes dons - MedConnect</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="dashboard.jsp">
                <span class="align-middle">Espace Donneur</span>
            </a>

            <ul class="sidebar-nav">
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="dashboard.jsp">
                        <i data-feather="activity" class="align-middle"></i>
                        <span class="align-middle">Tableau de bord</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="dons">
                        <i data-feather="calendar" class="align-middle"></i>
                        <span class="align-middle">Historique de dons</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="annonces.jsp">
                        <i data-feather="alert-triangle" class="align-middle"></i>
                        <span class="align-middle">Annonces urgentes</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="profil.jsp">
                        <i data-feather="user" class="align-middle"></i>
                        <span class="align-middle">Profil</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link text-danger" href="../logout">
                        <i data-feather="log-out" class="align-middle"></i>
                        <span class="align-middle">Déconnexion</span>
                    </a>

                </li>
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
                        <img src="../assets/img/avatar-donor.png" class="avatar img-fluid rounded me-1" alt="Donneur" />
                        <span><%= ((blooddonation.bean.Donneur) session.getAttribute("user")).getPrenom() %></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a class="dropdown-item" href="profil.jsp">Mon Profil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-danger" href="../logout.jsp">Déconnexion</a>
                    </div>
                </li>
            </ul>
        </nav>

        <!-- Content -->
        <main class="content">
            <div class="container-fluid p-0">
                <h1 class="h3 mb-3">Historique de mes dons</h1>

                <div class="card">
                    <div class="card-header">Liste de vos dons récents</div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Hôpital</th>
                                <th>Ville</th>
                                <th>Groupe sanguin</th>
                                <th>Date du don</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<Don> dons = (List<Don>) request.getAttribute("dons");
                                if (dons != null && !dons.isEmpty()) {
                                    int i = 1;
                                    for (Don d : dons) {
                            %>
                            <tr>
                                <td><%= i++ %></td>
                                <td><%= d.getDemande().getHopital().getNom() %></td>
                                <td><%= d.getDemande().getHopital().getVille() %></td>
                                <td><%= d.getDemande().getGroupeSanguin() %></td>
                                <td><%= d.getDateDon() %></td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr><td colspan="5" class="text-center text-muted">Aucun don enregistré.</td></tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </main>

        <!-- Footer -->
        <footer class="footer">
            <div class="container-fluid text-center text-muted">
                © 2025 MedConnect - Espace Donneur
            </div>
        </footer>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>feather.replace()</script>
</body>
</html>
