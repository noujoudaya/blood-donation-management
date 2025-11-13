<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="blooddonation.bean.Demande" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Espace Donneur - MedConnect</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
<div class="wrapper">

    <!-- Sidebar -->
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
                <h1 class="h3 mb-3">Tableau de bord - Donneur</h1>

                <!-- STATISTICS -->
                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Total des dons</h5>
                                <h1 class="mb-3"><%= request.getAttribute("totalDons") %></h1>
                                <span class="text-muted">Depuis votre inscription</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Dernier don</h5>
                                <h4><%= request.getAttribute("lastDonation") %></h4>
                                <span class="text-muted">Merci pour votre générosité</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Prochain don possible</h5>
                                <h4><%= request.getAttribute("nextDonation") %></h4>
                                <span class="text-muted">Après la période de repos</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Groupe sanguin</h5>
                                <h3 class="text-danger"><%= ((blooddonation.bean.Donneur) session.getAttribute("user")).getGroupeSanguin() %></h3>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- URGENT ANNOUNCEMENTS -->
                <div class="card mt-4">
                    <div class="card-header">Annonces urgentes pour votre groupe sanguin</div>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Hôpital</th>
                                <th>Ville</th>
                                <th>Date</th>
                                <th>Statut</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<Demande> urgentDemands = (List<Demande>) request.getAttribute("urgentDemands");
                                if (urgentDemands != null && !urgentDemands.isEmpty()) {
                                    for (Demande d : urgentDemands) {
                            %>
                            <tr>
                                <td><%= d.getIdDemande() %></td>
                                <td><%= d.getHopital().getNom() %></td>
                                <td><%= d.getHopital().getVille() %></td>
                                <td><%= d.getDateDemande() %></td>
                                <td>
                                    <% if (d.getStatut().name().equals("Urgent") || d.getStatut().name().equals("Critique")) { %>
                                    <span class="badge bg-danger"><%= d.getStatut() %></span>
                                    <% } else { %>
                                    <span class="badge bg-warning"><%= d.getStatut() %></span>
                                    <% } %>
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr><td colspan="5" class="text-center text-muted">Aucune annonce urgente pour votre groupe sanguin.</td></tr>
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
