 function toggleSidebar() {
         var sidebar = document.getElementById("sidebar");
         var mainContent = document.getElementById("main-content");
         var toggleBtn = document.getElementById("toggle-btn");
         if (sidebar.classList.contains("hidden")) {
             sidebar.classList.remove("hidden");
             mainContent.classList.remove("full-width");
             toggleBtn.classList.remove("collapsed");
         } else {
             sidebar.classList.add("hidden");
             mainContent.classList.add("full-width");
             toggleBtn.classList.add("collapsed");
         }
     }
     function toggleChat() {
         var chatBox = document.getElementById("chat-box");
         var chatToggleBtn = document.getElementById("chat-toggle-btn");
         if (chatBox.classList.contains("hidden")) {
             chatBox.classList.remove("hidden");
             chatToggleBtn.textContent = "×"; // Change button text to "×" when chat is open
         } else {
             chatBox.classList.add("hidden");
             chatToggleBtn.textContent = "💬"; // Change button text to "💬" when chat is closed
         }
     }