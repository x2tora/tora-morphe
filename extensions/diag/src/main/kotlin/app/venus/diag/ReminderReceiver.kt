package app.venus.diag

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        try {
            val id = intent.getStringExtra("id") ?: "0"
            val title = intent.getStringExtra("title") ?: "Message Reminder"
            val text = intent.getStringExtra("text") ?: ""
            val channelName = intent.getStringExtra("channelName") ?: "Venus Reminders"
            val channelDesc = intent.getStringExtra("channelDesc") ?: "Scheduled message reminders"
            val guildId = intent.getStringExtra("guildId") ?: ""
            val channelId = intent.getStringExtra("channelId") ?: ""
            val messageId = intent.getStringExtra("messageId") ?: ""
            Diagnostics.showReminderNotification(
                context, id, title, text, channelName, channelDesc, guildId, channelId, messageId
            )
        } catch (_: Throwable) { }
    }
}
