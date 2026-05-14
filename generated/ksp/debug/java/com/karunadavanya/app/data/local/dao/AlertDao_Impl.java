package com.karunadavanya.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.karunadavanya.app.data.local.entity.AlertEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlertDao_Impl implements AlertDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlertEntity> __insertionAdapterOfAlertEntity;

  private final SharedSQLiteStatement __preparedStmtOfExpireOldAlerts;

  public AlertDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlertEntity = new EntityInsertionAdapter<AlertEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `alerts` (`id`,`animalType`,`location`,`notes`,`timestamp`,`isExpired`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlertEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getAnimalType());
        statement.bindString(3, entity.getLocation());
        statement.bindString(4, entity.getNotes());
        statement.bindLong(5, entity.getTimestamp());
        final int _tmp = entity.isExpired() ? 1 : 0;
        statement.bindLong(6, _tmp);
      }
    };
    this.__preparedStmtOfExpireOldAlerts = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alerts SET isExpired = 1 WHERE timestamp <= ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAlert(final AlertEntity alert, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlertEntity.insertAndReturnId(alert);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object expireOldAlerts(final long expiryTime,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfExpireOldAlerts.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, expiryTime);
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfExpireOldAlerts.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AlertEntity>> getActiveAlerts() {
    final String _sql = "SELECT * FROM alerts WHERE isExpired = 0 ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alerts"}, new Callable<List<AlertEntity>>() {
      @Override
      @NonNull
      public List<AlertEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAnimalType = CursorUtil.getColumnIndexOrThrow(_cursor, "animalType");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfIsExpired = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpired");
          final List<AlertEntity> _result = new ArrayList<AlertEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlertEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpAnimalType;
            _tmpAnimalType = _cursor.getString(_cursorIndexOfAnimalType);
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpIsExpired;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsExpired);
            _tmpIsExpired = _tmp != 0;
            _item = new AlertEntity(_tmpId,_tmpAnimalType,_tmpLocation,_tmpNotes,_tmpTimestamp,_tmpIsExpired);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
