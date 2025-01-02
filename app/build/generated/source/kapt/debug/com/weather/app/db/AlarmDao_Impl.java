package com.weather.app.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlarmEntity> __insertionAdapterOfAlarmEntity;

  private final EntityDeletionOrUpdateAdapter<AlarmEntity> __deletionAdapterOfAlarmEntity;

  private final EntityDeletionOrUpdateAdapter<AlarmEntity> __updateAdapterOfAlarmEntity;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarmEntity = new EntityInsertionAdapter<AlarmEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `alarms` (`id`,`timeInMillis`,`label`,`isEnabled`,`repeatDays`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlarmEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTimeInMillis());
        if (value.getLabel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLabel());
        }
        final int _tmp = value.isEnabled() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getRepeatDays() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRepeatDays());
        }
      }
    };
    this.__deletionAdapterOfAlarmEntity = new EntityDeletionOrUpdateAdapter<AlarmEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `alarms` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlarmEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAlarmEntity = new EntityDeletionOrUpdateAdapter<AlarmEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `alarms` SET `id` = ?,`timeInMillis` = ?,`label` = ?,`isEnabled` = ?,`repeatDays` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlarmEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTimeInMillis());
        if (value.getLabel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLabel());
        }
        final int _tmp = value.isEnabled() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getRepeatDays() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRepeatDays());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insert(final AlarmEntity alarm, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAlarmEntity.insert(alarm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final AlarmEntity alarm, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAlarmEntity.handle(alarm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final AlarmEntity alarm, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlarmEntity.handle(alarm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<AlarmEntity>> getAllAlarms() {
    final String _sql = "SELECT `alarms`.`id` AS `id`, `alarms`.`timeInMillis` AS `timeInMillis`, `alarms`.`label` AS `label`, `alarms`.`isEnabled` AS `isEnabled`, `alarms`.`repeatDays` AS `repeatDays` FROM alarms ORDER BY timeInMillis ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"alarms"}, new Callable<List<AlarmEntity>>() {
      @Override
      public List<AlarmEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTimeInMillis = 1;
          final int _cursorIndexOfLabel = 2;
          final int _cursorIndexOfIsEnabled = 3;
          final int _cursorIndexOfRepeatDays = 4;
          final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlarmEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final long _tmpTimeInMillis;
            _tmpTimeInMillis = _cursor.getLong(_cursorIndexOfTimeInMillis);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final String _tmpRepeatDays;
            if (_cursor.isNull(_cursorIndexOfRepeatDays)) {
              _tmpRepeatDays = null;
            } else {
              _tmpRepeatDays = _cursor.getString(_cursorIndexOfRepeatDays);
            }
            _item = new AlarmEntity(_tmpId,_tmpTimeInMillis,_tmpLabel,_tmpIsEnabled,_tmpRepeatDays);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
