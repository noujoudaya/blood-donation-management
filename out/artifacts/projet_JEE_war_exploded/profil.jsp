<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <title>MedConnect - Profil</title>
    <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        :root{
            --bg:#f6f8fb;
            --card:#ffffff;
            --accent:#ff6b6b; /* pink/red accent from image */
            --navy:#0a1a2f;
            --muted:#9aa4b2;
            --soft:#f3f6f9;
        }
        body { background: var(--bg); font-family: "Segoe UI", Roboto, Arial, sans-serif; }
        .sidebar {
            width: 92px;
            height: 100vh;
            background: white;
            position: fixed;
            left: 0; top: 0;
            padding-top: 24px;
            border-right: 1px solid #f0f2f6;
        }
        .sidebar .logo { writing-mode: vertical-rl; transform: rotate(180deg); font-weight:700; color:var(--accent); margin-bottom: 20px; text-align:center;}
        .sidebar .menu { margin-top: 20px; }
        .sidebar .menu a { display:block; padding: 18px 12px; color: #c1c8d0; text-align:center; font-size:12px; text-decoration:none; }
        .sidebar .menu a.active { background: linear-gradient(180deg,#fff,#fff); color:var(--accent); border-radius:10px; }

        .topbar { margin-left:92px; height:80px; display:flex; align-items:center; justify-content:space-between; padding:0 28px; background:transparent; }
        .topbar .search { width:420px; }
        .topbar .user { display:flex; align-items:center; gap:12px; }

        .container-main { margin-left:92px; padding: 20px 28px 60px; }

        /* Cards layout */
        .profile-card {
            background:var(--card);
            border-radius:16px;
            box-shadow: 0 8px 24px rgba(20,30,50,0.06);
            padding:26px;
        }
        .profile-head { display:flex; gap:22px; align-items:center; }
        .avatar { width:96px; height:96px; border-radius:12px; overflow:hidden; flex-shrink:0; }
        .avatar img{ width:100%; height:100%; object-fit:cover; }

        .profile-name { font-size:20px; font-weight:800; }
        .profile-role { color:var(--muted); font-size:13px; margin-top:6px; }
        .btn-edit { background: #fff; border:1px solid #eee; color:var(--navy); padding:8px 12px; border-radius:10px; box-shadow:none; }

        .info-row { display:flex; gap:18px; margin-top:18px; flex-wrap:wrap; }
        .info-box { flex:1 1 45%; background:var(--soft); padding:12px 14px; border-radius:10px; color:var(--navy); font-weight:600; }

        .bio { margin-top:18px; color:#6b7280; line-height:1.5; }

        /* right column cards smaller */
        .small-card { background:var(--card); border-radius:14px; padding:18px; box-shadow: 0 8px 24px rgba(20,30,50,0.06); }

        .contacts-list img { width:40px; height:40px; border-radius:8px; object-fit:cover; }

        .message-item { display:flex; gap:12px; align-items:center; padding:10px; border-radius:10px; }
        .message-item .meta { color:#6b7280; font-size:13px; }

        .recent-activity li { margin-bottom:14px; color:#475667; }

        /* responsive tweaks */
        @media(max-width: 992px){
            .topbar .search{ width:200px; }
            .profile-head{ flex-direction:column; align-items:flex-start; gap:12px;}
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar d-flex flex-column align-items-center">
    <div class="logo">PROJECT<br/><span style="color:var(--navy); font-weight:600;">Donor</span></div>
    <div class="menu w-100">
        <a href="#" class="active">🏠</a>
        <a href="#">👥</a>
        <a href="#">🩸</a>
        <a href="#">➕</a>
        <a href="#">👤</a>
    </div>
</div>

<!-- Topbar -->
<div class="topbar">
    <div class="search">
        <input class="form-control" placeholder="Search here" />
    </div>
    <div class="user">
        <div class="icons" style="display:flex; gap:12px; align-items:center; color:#6b7280;">
            🔔 💬 ⚙️
        </div>
        <div style="display:flex; align-items:center; gap:10px;">
            <div style="text-align:right;">
                <div style="font-weight:700">${donor.name}</div>
                <div style="font-size:12px;color:#98a0ab;">${donor.role}</div>
            </div>
            <div style="width:44px;height:44px;border-radius:50%;overflow:hidden;">
                <img src="${pageContext.request.contextPath}/${donor.avatar}" alt="avatar" style="width:100%;height:100%;object-fit:cover;">
            </div>
        </div>
    </div>
</div>

<!-- Main content -->
<div class="container-main">
    <div class="row gx-4">
        <!-- Left big profile -->
        <div class="col-lg-6">
            <div class="profile-card">
                <div class="profile-head">
                    <div class="avatar">
                        <img src="${pageContext.request.contextPath}/${donor.avatar}" alt="avatar">
                    </div>
                    <div style="flex:1;">
                        <div class="profile-name">${donor.name}</div>
                        <div class="profile-role">Admin at <span style="color:var(--accent)">Project-Donor</span></div>
                        <div style="margin-top:12px;">
                            <button class="btn-edit">✏️ Edit Profile</button>
                        </div>
                    </div>
                </div>

                <div class="info-row">
                    <div class="info-box">
                        <div style="font-size:12px;color:#8b97a6;">Phone</div>
                        <div style="margin-top:6px;">${donor.phone}</div>
                    </div>
                    <div class="info-box">
                        <div style="font-size:12px;color:#8b97a6;">Email</div>
                        <div style="margin-top:6px;">${donor.email}</div>
                    </div>

                    <div class="info-box">
                        <div style="font-size:12px;color:#8b97a6;">Address</div>
                        <div style="margin-top:6px;">${donor.address}</div>
                    </div>
                    <div class="info-box">
                        <div style="font-size:12px;color:#8b97a6;">Website</div>
                        <div style="margin-top:6px;">${donor.website}</div>
                    </div>
                </div>

                <div class="bio">
                    <h5>Bio</h5>
                    <p>${donor.bio}</p>
                </div>
            </div>
        </div>

        <!-- Middle column (plan + contacts) -->
        <div class="col-lg-3">
            <div class="small-card mb-4">
                <div style="display:flex; justify-content:space-between; align-items:center;">
                    <div>
                        <div style="font-size:12px;color:#98a0ab;">Your plan</div>
                        <div style="font-weight:800; font-size:20px; margin-top:6px;">${plan.title}</div>
                    </div>
                    <div style="width:54px;height:54px;border-radius:12px;background:linear-gradient(135deg,#ff9a9e,#fecfef);"></div>
                </div>
                <ul style="margin-top:12px; padding-left:18px; color:#6b7280;">
                    <li>${plan.storage}</li>
                    <li>${plan.features}</li>
                </ul>
            </div>

            <div class="small-card">
                <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:12px;">
                    <div style="font-weight:800;">Contacts</div>
                    <button style="background:var(--accent); border:none; color:white; border-radius:8px; padding:6px 8px;">+</button>
                </div>
                <div class="contacts-list">
                    <c:forEach var="c" items="${contacts}">
                        <div style="display:flex; align-items:center; gap:12px; padding:10px 0; border-bottom:1px solid #f0f2f6;">
                            <img src="${pageContext.request.contextPath}/${c.avatar}" alt="contact">
                            <div style="font-weight:600;">${c.name}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <!-- Right column (messages + activity) -->
        <div class="col-lg-3">
            <div class="small-card mb-4">
                <div style="font-weight:800; margin-bottom:12px;">Latest Message</div>
                <div>
                    <c:forEach var="m" items="${messages}">
                        <div class="message-item">
                            <img src="${pageContext.request.contextPath}/${m.avatar}" style="width:48px;height:48px;border-radius:8px;">
                            <div style="flex:1;">
                                <div style="font-weight:700;">${m.name}</div>
                                <div class="meta">${m.text}</div>
                            </div>
                            <div style="font-size:12px;color:#9aa4b2;">${m.time}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="small-card">
                <div style="font-weight:800; margin-bottom:12px;">Recent Activity</div>
                <ul class="recent-activity" style="list-style:none; padding-left:0;">
                    <c:forEach var="a" items="${activities}">
                        <li>
                            <strong style="color:var(--accent);">●</strong>
                            <span style="margin-left:8px; font-weight:700;">${a.date}</span>
                            <div style="font-size:13px; color:#6b7280;">${a.text}</div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>
