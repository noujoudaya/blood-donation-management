<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="blooddonation.bean.Donneur" %>
<%
    Donneur donneur = (Donneur) request.getAttribute("donneur");
    if (donneur == null) {
        donneur = (Donneur) session.getAttribute("user");
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Profil - Donneur</title>
    <link href="../assets/dist/css/app.css" rel="stylesheet">
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
    <div class="main">
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
        <main class="content">
            <div class="container-fluid p-0">
                <h1 class="h3 mb-3">Modifier mon profil</h1>

                <div class="card">
                    <div class="card-body">
                        <form action="<%= request.getContextPath() %>/donneur/update" method="post">
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <label>Prénom</label>
                                    <input name="prenom" type="text" class="form-control" value="<%= donneur.getPrenom() %>">
                                </div>
                                <div class="col-md-6">
                                    <label>Nom</label>
                                    <input name="nom" type="text" class="form-control" value="<%= donneur.getNom() %>">
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" value="<%= donneur.getEmail() %>">
                                </div>
                                <div class="col-md-6">
                                    <label>Téléphone</label>
                                    <input name="telephone" type="text" class="form-control" value="<%= donneur.getPhoneNum() %>">
                                </div>
                            </div>

                            <div class="mb-3">
                                <label>Adresse</label>
                                <input name="adresse" type="text" class="form-control" value="<%= donneur.getAdresse() %>">
                            </div>

                            <div class="row mb-3">
                                <div class="col-md-4">
                                    <label>Groupe sanguin</label>
                                    <select name="groupeSanguin" class="form-select">
                                        <option value="">--</option>
                                        <% for (blooddonation.enums.GroupeSang gs : blooddonation.enums.GroupeSang.values()) { %>
                                        <option value="<%= gs.name() %>" <%= (donneur.getGroupeSanguin()!=null && donneur.getGroupeSanguin().name().equals(gs.name())) ? "selected" : "" %>><%= gs.name() %></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="col-md-4">
                                    <label>Disponibilité</label>
                                    <select name="disponibilite" class="form-select">
                                        <option value="">--</option>
                                        <% for (blooddonation.enums.StatusDisponibilite sd : blooddonation.enums.StatusDisponibilite.values()) { %>
                                        <option value="<%= sd.name() %>" <%= (donneur.getDisponibilite()!=null && donneur.getDisponibilite().name().equals(sd.name())) ? "selected" : "" %>><%= sd.name() %></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="col-md-4">
                                    <label>Dernier don</label>
                                    <input type="date" name="dateDernierDon" class="form-control"
                                           value="<%= (donneur.getDateDernierDon() != null) ? donneur.getDateDernierDon().toString() : "" %>">
                                </div>
                            </div>

                            <div class="text-end">
                                <a href="profil" class="btn btn-secondary">Annuler</a>
                                <button type="submit" class="btn btn-primary">Enregistrer</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script>feather.replace()</script>
</body>
</html>
